/*
Challenge: Maximum Consecutive Ones
Given an array which only consists of 0s and 1s
Write a code to find the maximum number of consecutive 1s present in an array.
For example:
Input: {1, 1, 0, 1, 1, 1, 1, 1, 0}
Output: 5

Maximum consecutive ones present in this array is 5

Logic:
To solve this problem, we need to maintain two counters, one for counting number of 1s and another for keeping track of max consecutive 1s
Traverse through the array, whenever you encounter a 1 increment the counter and when you encounter 0 reset the counter
*/
import java.util.*;
public class MaxConsecutiveOnes{
	public static void main(String args[]){
		int[] arr = {1, 1, 0, 1, 1, 1, 1, 1, 0};
		System.out.println(countConsecutiveOnes(arr));
	}

	public static int countConsecutiveOnes(int[] arr){
		int count = 0;
		int maxConsecutiveOnes = 0;

		for(int i = 0; i < arr.length; i++){
			if(arr[i] == 1){
				count++;
				maxConsecutiveOnes = Math.max(count, maxConsecutiveOnes);
			} else {
				count = 0;
			}
		}
		return maxConsecutiveOnes;
	}
}
