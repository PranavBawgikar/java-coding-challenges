/*
Challenge: Majority Element in an Array
Given an array of integers, find the majority element.
The majority element is the element that appears more than n/2 times (where n is the size of an array).

For example:
Input: {3, 3, 2, 2, 3, 2, 3}
output: 3

Hint: To find the majority element in an array we need to find all the numbers of an array and their count.
We will be using a HashMap to store the number and its count
*/
import java.util.HashMap;
import java.util.Map;
public class MajorityElement {
	public static void main(String[] args) {
		int[] arr = {3, 3, 2, 2, 3, 2, 3};
		int result = majorityElement(arr);
		System.out.println(result);
	}

	public static int majorityElement(int[] arr) {
		Map<Integer, Integer> countMap = new HashMap<>();
		Integer result = null;

		for(int i = 0; i < arr.length; i++) {
			countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
		}
		int val = arr.length / 2;
		for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			if(entry.getValue() > val) {
				result = entry.getKey();
				break;
			}
		}
		return result;
	}
}