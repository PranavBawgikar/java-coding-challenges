/*
Challenge: Solve Me First (Source: Hackerrank)
Complete the function solveMeFirst to compute the sum of two integers.

Function Prototype:
int solveMeFirst(int a, int b)
where, 
a is the first integer input
b is the second integre input

Return value
sum of the above two values

p.s. it's not even a challenege -_-
*/
import java.util.Scanner;
public class SolveMeFirst{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter value for a: ");
		int a = s.nextInt();
		System.out.println("Enter value for b: ");
		int b = s.nextInt();
		System.out.println(solveMeFirst(a, b));
	}
	static int solveMeFirst(int a, int b){
		return a + b;
	}
}