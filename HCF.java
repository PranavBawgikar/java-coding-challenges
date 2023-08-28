/*
Challenge: HCF of two numbers withour Recursion
Given two integer x and y, the task is to find the HCF of the numbers without using recursion
Examples: 

Input: x = 16, y = 32 
Output: 16

Input: x = 12, y = 15 
Output: 3 

Approach: HCF of two numbers is the greatest number which can divide both the numbers. If the smaller of the two numbers can divide the larger number then the HCF is the smaller number. Else starting from (smaller / 2) to 1 check whether the current element divides both the numbers . If yes, then it is the required HCF.
*/
import java.util.Scanner;
public class HCF {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int y = s.nextInt();
		x = (x > 0) ? x : - x;
		y = (y > 0) ? y : - y;
		int result = getHCF(x, y);
		System.out.println(result);
	}

	public static int getHCF(int x, int y) {
		int min = Math.min(x, y);
		while(min > 0) {
			if(x % min == 0 && y % min == 0) {
				break;
			}
			min--;
		}
		return min;
	}
}