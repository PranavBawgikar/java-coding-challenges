/*
Challenge: Zeroes to the End
Given an array of integers, write a function to move all 0's to end of it while maintaining the relative order of the non-zero elements.

Example:
Given array of integers: {0, 1, 0, 4, 12}

Solution:
{1, 4, 12, 0, 0}
*/
import java.util.Scanner;
public class ZeroesToLast{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the array length:");
		int n = s.nextInt();
		System.out.println("Enter the array elements:");
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = s.nextInt();
		}
		int[] result = moveZeroes(arr, n);
		for(int i = 0; i < n; i++){
			System.out.print(result[i] + " ");
		}
	}

	static int[] moveZeroes(int[] arr, int n){
		//Basically, we will start by creating two pointers, one for Non-zero elements and another for Zero element.
		int j = 0; //Here, i is for Non-zero and j for Zero elements
		for(int i = 0; i < n; i++){
			if(arr[i] !=0 && arr[j] == 0){  //We first check if the value at the 'i'th index is 0 or not and we also check if 'j'th == 0
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}  
			if(arr[j] != 0){
				j++;
			}
		}
		return arr;
	}
}

//When evaluating two conditions combined together using &&, if the first condition turns out to be false, the second condition will not even be checked