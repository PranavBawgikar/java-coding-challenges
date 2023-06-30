/*
Challenge: Balancing Stars
CODU loves to play with strings of brackets.
He considers string as a good string if it is balanced with stars. 
A string is considered balanced with stars if the string contains balanced brackets and between every pair of brackets, i.e. between opening and closing brackets, there are at least 2 stars(*) present.
CODU knows how to check whether a string is balanced or not, but this time he needs to keep a track of stars too.
He decided to write a program to check whether a string is good or not.
But CODU is not as good in programming as you are, so he decided to take help from you. 
Will you help him with this task? You need to print Yes and the number of balanced pair if the string satisfies the following conditions(string is good if it satisfies the following 2 conditions):

1. The string is balanced with respect to all brackets.
2. Between every pair of bracket there is at least two stars. However, if the string doesn't satisfy the above conditions, then print No and the number of balanced pairs in the string as an output.

Input format:
The first and only line of input contains a string of characters (a-zA- z), numbers (0-9), brackets('{' '['. 'C'), ']'. '}') and stars(*).

Output format:
Print a space-separated "Yes" (without quotes) and the number of balanced pairs if the string is good. Else print "No" (without quotes) and the number of balanced pairs.

Code constraints:
4<= String length <= 1000

Sample test cases:
Input 1:
(**)

Output 1:
Yes 1

Input 2:
{{[[**]]}}anbu{}{{}

Output 2:
No 1
*/

import java.util.Scanner;
import java.util.Stack;

public class BalancedStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int balancedPairs = 0; //keeps track of the number of balanced pairs of brackets found in the string
        int starCount = 0; //keeps track of the total number of stars (*) in the string
        Stack<Character> stack = new Stack<>(); //is a stack data structure used to keep track of the opening brackets encountered while traversing the string
        //Traversing the string
        for (char c : str.toCharArray()) { //to traverse each character in the input string
        	//The toCharArray() method is used in the code to convert the input string into a character array. 
        	//It splits the string into an array of characters, where each character represents an element of the array.
            if (c == '*') {
                starCount++;
                //Whenever the code encounters a star (*), it increments the starCount variable to keep track of the total number of stars in the string
                //Handling Brackets
            } else if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') { //checking if the stack is not empty and the top element of the stack matches the corresponding opening bracket for the current closing bracket when the ')' is encountered
                //if they match it means a balanced pair is found
                    stack.pop(); //poping the opening bracket from the stack
                    balancedPairs++;
                    //If the current closing bracket doesn't match the top element of the stack, it means the string is not balanced. 
                    //In such cases, push the corresponding opening bracket onto the stack to indicate that it has encountered an unmatched closing bracket.
                } else {
                    stack.push('(');
                }
            } else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                    balancedPairs++;
                } else {
                    stack.push('[');
                }
            } else if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                    balancedPairs++;
                } else {
                    stack.push('{');
                }
            }
        }
        //If the stack is empty (all brackets are balanced) and the total number of stars (starCount) is greater than or equal to twice the number of balanced pairs (balancedPairs * 2), it means the string is good. 
        //In this case, print "Yes" followed by the number of balanced pairs.
        if (stack.isEmpty() && starCount >= balancedPairs * 2) {
            System.out.println("Yes " + balancedPairs);
        } else {
            System.out.println("No " + balancedPairs);
        }
    }
}
