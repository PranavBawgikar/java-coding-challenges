/*
Challenge: Sort Array by Parity
Given an array of non-negative integers, write a code to return an array consisting of all the even elements, followed by all the odd elements of an array.

Example 1:
Input: {3, 1, 2, 4}
Output: {2, 4, 3, 1}

The outputs {4, 2, 3, 1}, {2, 4, 1, 3} and {4, 2, 1, 3} would also be accepted.
Any output which satisfies following condition that first we need to put all the even elements, followed by all the odd elements of an array is valid.

Example 2:
Input: {10, 13, 44, 9}
Output: {10, 44, 13, 9}
*/

import java.util.Scanner;
public class ParitySort {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		// int[] result = rearrangedByParity(arr, n);
		int[] result = sortArrayByParity(arr, n);
		for(int i = 0; i < n; i++) {
			System.out.print(result[i] + " ");
		}
	}

	//Approach #1 - Time Complexity: O(n)
	public static int[] rearrangedByParity(int[] arr, int n) {
		int[] result = new int[n];
		int index = 0;

		for(int i = 0; i < n; i++) {
			if(arr[i] % 2 == 0) {
				result[index++] = arr[i];
			}
		}

		for(int i = 0; i < n; i++) {
			if(arr[i] % 2 != 0) {
				result[index++] = arr[i];
			}
		}

		return result;
	}

	//Approach #2 - Single Traversal by swapping elements
	public static int[] sortArrayByParity(int[] arr, int n) {
		int j = 0;

		for(int i = 0; i < n; i++) {
			if(arr[i] % 2 == 0) {
				int temp = arr[j];
				arr[j++] = arr[i];
				arr[i] = temp;
			}
		}

		return arr;
	}
}