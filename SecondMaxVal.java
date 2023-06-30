/*
Challenge: Second Maximum Value
Given an array of integers, return second maximum value. 

Constraint:
The second maximum value exists.

Example:
Input:
arr = {12, 34, 2, 34, 33, 1}

Output:
33
*/
import java.util.Scanner;
public class SecondMaxVal{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the array length:");
		int n = s.nextInt();
		System.out.println("Enter the array elements:");
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = s.nextInt();
		}
		int result = findSecondMax(arr, n);
		System.out.println("Your second maximum value is "+ result);
	}

	static int findSecondMax(int[] arr, int n){
		//We will create two variables, max and secondMax
		int max = Integer.MIN_VALUE; //assinging the minimum integer value
		int secondMax = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++){
			if(arr[i] > max){
				secondMax = max;
				max = arr[i];
				//checking for max value, and before assigning the current i value to max we must first update our secondMax value
			} else if(arr[i] > secondMax && arr[i] != max){ //this condition is basically to check if the current i value is greater than our secondMax or not even if it is not greater than our max value
				secondMax = arr[i];
			}
		}
		return secondMax;
	}
}