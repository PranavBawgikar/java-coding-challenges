/*
Challenge: Maximum Subarray Sum/Kadane's Algorithm
Given an integer array, find the contiguous subarray (containing atleast one number) which has the largest sum and return its sum.

Example:
Input 1:
arr[] = {1, 2, -5, 4, 3, 8, 5}

Output 1:
20
The subarray is (4, 3, 8, 5)

Input 2:
arr[] = {-2, -1}

Output 2:
-1
The subarray is (-1)
*/

import java.util.Scanner;

public class MaxSubarraySum {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		int result = findMaxSubarraySum(arr, n);
		System.out.println(result);
	}

	public static int findMaxSubarraySum(int[] arr, int n) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int currSum = 0;
            for (int j = i; j < n; j++) {
            	currSum += arr[j];
            	if (currSum > maxSum) {
                	maxSum = currSum;
            	}
            }
        }
		return maxSum;
	}
}