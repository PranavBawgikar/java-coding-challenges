/*E
Challenge: Golden Letters (Source: HackerEarth)
You are given a string key that contains a list of golden letters.
You are also given another string str.
Find out how many characters in str are golden letters.

Input:
key - a string of golden letters
str - the string to be checked

Output:
The number of golden letters in str

Hint: Use of HashSets
*/
import java.util.Scanner;
import java.util.HashSet;
public class GoldenLetters{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter The Golden Letters:");
		String key = s.nextLine();
		System.out.println("Enter The String:");
		String str = s.nextLine();
		int result = golden_char(key, str);
		System.out.println(result);
	}

	static int golden_char(String key, String str){
		int result = 0;
		HashSet<Character> set = new HashSet<Character>(); //creating a HashSet called set which stores characters as its key
		//populating the HashSet with every single character inside the key
		for(int i = 0; i < key.length(); i++)
			set.add(key.charAt(i));
		//creating a for loop to check if each character inside str is present in HashSet or not, if it is we increment our result else simply ignore it
		for(int j = 0; j < str.length(); j++)
			if(set.contains(str.charAt(j)))
				result++;
		return result;
	}
}