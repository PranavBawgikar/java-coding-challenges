/*
Challenge: Missingno! (Source: HackerEarth)
You are given an integer n, along with an array of n-1 numbers in the range 1 to n, with no duolicates. One number is missing from the array, find that number

Input:
n - an integer
arr - an array of size n-1

Output:
The single missing number

Sample: Say you've been given an array size of 4 and an array consisting of elements <4, 1, 2>. 
Now in this, what's missing is the number 3, so we need to print that.

Hint: Use of - 1 + 2 + 3 +...+ n = n * (n + 1)/2
*/
import java.util.Scanner;
public class Missingno{
	public static void main(String[] args) {
		System.out.println("Enter the number of Array Elements: ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println("Enter the Array Elements: ");
		int[] arr = new int[n];
		for(int i = 0; i < n - 1; i++){
			arr[i] = s.nextInt();
		}
		System.out.println("The Missing Element: " + missingNo(n, arr));
	}

	static int missingNo(int n, int[] arr){
		int result = n * (n + 1) / 2;
		int arraySum = 0; //sum of our array elements
		for(int i = 0; i < n - 1; i++){
			arraySum = arraySum + arr[i]; //7
		}
		result = result - arraySum;
		return result;
	}
}