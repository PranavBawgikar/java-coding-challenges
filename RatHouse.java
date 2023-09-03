/*
Challenge: Rat Count House
The function accepts two positive integers ‘r’ and ‘unit’ and a positive integer array ‘arr’ of size ‘n’ as its argument 
‘r’ represents the number of rats present in an area, ‘unit’ is the amount of food each rat consumes and each ith element of array ‘arr’ represents the amount of food present in ‘i+1’ house number, where 0 <= i

Note:
Return -1 if the array is null
Return 0 if the total amount of food from all houses is not sufficient for all the rats.
Computed values lie within the integer range.

Example:
Input:
r: 7
unit: 2
n: 8
arr: 2 8 3 5 7 4 1 2

Explanation:
Total amount of food required for all rats = r * unit = 7 * 2 = 14.
The amount of food in 1st houses = 2+8+3+5 = 18. Since, amount of food in 1st 4 houses is sufficient for all the rats. Thus, output is 4.
*/
import java.util.Scanner;
public class RatHouse {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int r = s.nextInt();
		int unit = s.nextInt();
		int n = s.nextInt(); //Number of houses
		int[] arr = new int[n]; //Array containing amount of food in each house
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		System.out.println(solve(r, unit, arr, n));
	}

	public static int solve(int r, int unit, int[] arr, int n) {
		if(arr == null)
			return -1;
		int res = r * unit; //Total amount of food required for all rats
		int sum = 0; //Sum of food amounts
		int count = 0; //To keep track of number of houses visited
		for(int i = 0; i < n; i++) {
			sum += arr[i];
			count++;
			if(sum >= res)
				break;
		}
		if(sum < res) //After the loop, if the sum is still less than res, it means there isn't enough food in the houses to feed all rats, and the method returns 0 as specified.
			return 0;
		return count; //Represents the number of houses visited to provide the food
	}
}