/*
Challenge: Array/String Reversal
Given an array or string, the task is to reverse the array or string.

Example:
Given array of integers - {2, 11, 5, 10, 7, 8}

Output:
Return reverse of array - {8, 7, 10, 5, 11, 2}
*/

import java.util.Scanner;
public class RevArr{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the array length:");
		int n = s.nextInt();
		System.out.println("Enter the array elements:");
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = s.nextInt();
		}
		int[] result = reverseArray(arr, 0, arr.length - 1);
		System.out.println("The reversed array ");
		for(int i = 0; i < n; i++){
			System.out.print(arr[i] + " ");
		}
	}

	static int[] reverseArray(int[] arr, int start, int end){
		while(start < end){
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		return arr;
	}
}