/*
Challenge: Count Inversions in an Array
Given an array of integers, find the inversion count in the array.
Inversion Count: For an array, the inversion count indicates how far (or close) the array is from being sorted. 
If the array is already sorted, then the inversion count is 0. 
If an array is sorted in reverse order, then the inversion count is the maximum.
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i<j.

The inversion count for any array is the number of steps it will take for the array to be sorted, or how far away any array is from being sorted. If we are given an array sorted in reverse order, the inversion count will be the maximum number in that array. The inversion count for an array sorted in increasing order will be zero.

Inversion will be counted if arr[i] is greater than arr[j] where i is lesser than j.

Example 1:
Input:
N=5, arr[] = {2, 4, 1, 3, 5}

Output:
3

Explanation:
Sequence 2, 4, 1, 3, and 5 has three inversions (2, 1), (4, 1), and (4,3).

Example 2:
Input:
N=5
arr[] = {2, 3, 4, 5, 6}

Output:
0

Explanation:
As the sequence is already sorted, there is no inversion count.

Example 3:
Input:
N = 3, arr[] = {10, 10, 10}

Output:
0

Explanation:
As all the elements of the array are the same, there is no inversion count.

Input format:
The first line of the input is the size of the array. The second line of the input is the list of space-separated integer values.

Output format:
The output is the inversion count in the array.

Code constraints:
1 ≤ N ≤ 5*105
1 s arr[i] ≤ 1018
*/
import java.util.Scanner;
public class CountInversion{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Size of Array:");
    	int n = s.nextInt();
    	int[] arr = new int[n];
    	System.out.println("Enter the array elements: ");
    	for (int x = 0; x < n; x++)
      		arr[x] = s.nextInt();
      	int result = findInversionCount(arr, n);
      	System.out.println("\nInversion Count:" + result);
	}

	static int findInversionCount(int[] arr, int n){
		int invCount = 0; //to store inversion count
		for(int i = 0; i < n; i++) //for each element for the array
			for(int j = i + 1; j < n; j++) //to compare the current element with the element to its right i.e., i + 1
				if(arr[i] > arr[j]){ //now if this is true
					invCount++; //increment the inversion count
					System.out.println("{" + arr[i] + "," + arr[j] + "}, ");
				}
		return invCount;
	}
}