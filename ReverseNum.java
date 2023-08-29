/*
Challenge: Reverse a Number
*/

import java.util.Scanner;
public class ReverseNum {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int rem;

		if(n <= 0) {
			System.out.println("Enter a positive integer.");
		}

		while(n > 0) {
			rem = n % 10;
			n = n / 10;
			System.out.print(rem);
		}
	}
}