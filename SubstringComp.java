/*
Challenge: Java Substring Comparisons
Given a string S, and an integer K, complete the function so that it finds the lexicographically (Lexicographical order, also known as alphabetic or dictionary order A < B < ... < Y < Z < a < b < ... < y < z) smallest and largest substrings of length K.

Input Format:
The first line contains a string denoting S.
The second line contains an integer denoting K.

Output Format:
Return the respective lexicographically smallest and largest substrings as a single newline-separated string.

Sample Input:
welcometojava
3

Sample Output:
ava
wel

Hint: The compareTo() method can be used to compare the substring with the current values of smallest and largest strings. 
It helps in determining if the substring is lexicographically smaller or larger than the current values.
Working for compareTo() method:
If the result is less than 0, it means that the substring comes before smallest in lexicographical order. Therefore, it is smaller and should replace the value of smallest.
If the result is equal to 0, it means that the substring and smallest are equal.
If the result is greater than 0, it means that the substring comes after smallest in lexicographical order. Therefore, it is not smaller and does not affect the value of smallest.
Similar concept for the 'largest'.
*/

import java.util.Scanner;

public class SubstringComp{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Reading string s and integer k from the input.
        String s = scanner.nextLine(); //original string
        int k = scanner.nextInt(); //length of the desired substring
        String result = getSmallestAndLargest(s, k);
        System.out.println(result);
        scanner.close();
    }

    public static String getSmallestAndLargest(String s, int k) {
    	//Initializing two variables, smallest and largest, to store the lexicographically smallest and largest substrings, respectively.
        String smallest = "zzz"; // Initialize with a large value
        String largest = ""; // Initialize with a small value

        //Iterating through the string S using a for loop from index 0 to s.length() - k.
        for (int i = 0; i <= s.length() - k; i++) {
            String substring = s.substring(i, i + k);
            if (substring.compareTo(smallest) < 0) { 
                smallest = substring;
            }
            if (substring.compareTo(largest) > 0) {
                largest = substring;
            }
        }
        return smallest + "\n" + largest;
    }
}
