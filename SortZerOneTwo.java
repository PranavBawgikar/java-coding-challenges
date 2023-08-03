/*
Challenge: Sort an Array of 0s, 1s and 2s
Given an array consisting 0s, 1s and 2s. We have to write a code to sort an array/
Input: {0, 1, 1, 0, 1, 2, 0, 1, 2}
Output: {0, 0, 0, 1, 1, 1, 1, 2, 2}

Method 1: Simply sorting the array using Quicksort. The time complexity of this approach is O(n log n).
Method 2: Simple Counting of the number of 0s, 1s and 2s. Now we have the count, we can simply put all 0s first then 1s and 2s. Time Complexity of this approach is O(n).
*/
public class SortZerOneTwo {
	public static void main(String[] args) {
		int[] arr = {0, 1, 1, 0, 1, 2, 0, 1, 2};
		arr = sort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static int[] sort(int[] arr) {
		int zeroCount = 0;
		int oneCount = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				zeroCount++;
			}
			if(arr[i] == 1) {
				oneCount++;
			}
		}
		for(int i = 0; i < zeroCount; i++) {
			arr[i] = 0;
		}
		for(int i = zeroCount; i < (zeroCount + oneCount); i++) {
			arr[i] = 1;
		}
		for(int i = (zeroCount + oneCount); i < arr.length; i++) {
			arr[i] = 2;
		}
		return arr;
	}
}