/*
Challenge: Hailstone Sequence
Write a program to find the Hailstone Sequence of a given number up to 1.

Input format:
The input consists of an integer.

Output format:
The output prints the Hailstone Sequence of the given number up to 1.

Sample test cases:
Input 1:
13

Output 1:
13 40 20 10 5 16 8 4 2 1 
The length of the sequence is 10.

The Hailstone Sequence, also known as the Collatz Sequence, is a sequence of numbers that begins with a positive integer and follows a specific rule to generate subsequent numbers. The rule is as follows:

If the current number (let's call it n) is even, divide it by 2 to obtain the next number.
If the current number is odd, multiply it by 3 and add 1 to obtain the next number.
By repeatedly applying this rule to the generated numbers, the sequence continues until it reaches the number 1, at which point the sequence stops.

For example, let's start with the number 6:
6 -> 3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
*/

import java.util.Scanner;

public class HailstoneSeq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        //Printing the initial number to start the sequence
        System.out.print(n + " ");

        int count = 1; //to keep track of the length of the sequence
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2; //if even, divided by two
            } else {
                n = (3 * n) + 1; //if odd, multiplied by 3 and then incremented by 1
            }
            System.out.print(n + " ");
            count++;
        }

        System.out.println();
        System.out.println("The length of the sequence is " + count + ".");
    }
}
