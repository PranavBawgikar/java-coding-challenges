/*
Challenge: Group Anagrams Together
Given an array of strings, group anagrams together

-What is an anagram?
 Two strings are said to be anagrams of each other, if it contains the same characters, only the order of character in both the strings is different.
 For example, word "car" and "rac" is anagram of each other.

Input: ["eat", "tea", "tan, "ate", "nat", "bat"]
Output:
[
	["ate", "eat", "tea"],
	["nat", "tan"],
	["bat"]
]
*/
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AnagramI {
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = groupAnagrams(strs);
		result.forEach(t -> System.out.println(t + " "));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<>();

		for(String str : strs) {
			char[] charArr = str.toCharArray();
			Arrays.sort(charArr);
			String key = new String(charArr);

			if(map.containsKey(key)) {
				map.get(key).add(str);
			} else {
				List<String> strList = new ArrayList<>();
				strList.add(str);
				map.put(key, strList);
			}
		}
		result.addAll(map.values());
		return result;
	}
}