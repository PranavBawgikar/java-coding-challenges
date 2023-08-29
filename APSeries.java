/*
Challenge: Sum of AP Series
Write a program to find the sum of the AP series

Example:
Input: a = 1, d = 2, n = 4
`a` is the first term
`d` is the common difference
`n` is the number of terms

Output: 16
1 + 3 + 5 + 7 = 16

Sum of arithmetic series is ((n / 2) * (2 * a + (n - 1) * d))
*/

import java.util.Scanner;

public class APSeries {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int d = s.nextInt();
		int n = s.nextInt();
		int result = sumOfAP(a, d, n);
		System.out.println(result);
	}

	public static int sumOfAP(int a, int d, int n) {
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum = sum + a;
			a = a + d;
		}
		return sum;
	}
}