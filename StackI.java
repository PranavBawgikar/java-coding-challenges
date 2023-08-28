/*M
Challenge: Java Stack (Source: HackerRank)
In computer science, a stack or LIFO (last in, first out) is an abstract data type that serves as a collection of elements, 
with two principal operations: push, which adds an element to the collection, and pop, which removes the last element that was added.
A string containing only parentheses is balanced if the following is true:
1. if it is an empty string 
2. if A and B are correct, AB is correct, 
3. if A is correct, (A) and {A} and [A] are also correct.

Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"
Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.
Given a string, determine if it is balanced or not.

Input Format:
There will be multiple lines in the input file, each having a single non-empty string. You should read the input till end-of-file.
The part of the code that handles input operation is already provided in the editor.

Output Format:
For each case, print 'true' if the string is balanced, 'false' otherwise.

Sample Input:
{}()
({()})
{}(
[]

Sample Output:
true
true
false
true
*/

import java.util.*;
class StackI{
    public static void main(String []argh)
    {
    	Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { //Continue the loop as long as there is more input to read
            String input= sc.next(); //Store the input variable
            System.out.println(checkIfBalanced(input,'{', '}') && checkIfBalanced(input,'[', ']') && checkIfBalanced(input,'(', ')'));
        }
    }

    public static boolean checkIfBalanced(String input, char opening, char closing){
        Stack<String> stack = new Stack<String>(); //To store the brackets
            for(int i = 0; i < input.length();i++){ //Looping through each character of the input
            	char c = input.charAt(i);
            	if(c == closing){ //I fthe current character is a closing bracket
                	if(!stack.empty()){ //Then check if the stack is empty or not (in this case it should not be)
                	stack.pop(); //Then remove an opening bracket from the stack
                	}else{ //If the stack is empty when closing bracket is encountered, it means the brackets are not balanced, so
                	return false;
                	}
            	}
            	if(c == opening){ //If the current character is an opening bracket
                	stack.push(String.valueOf(c)); //Add the string representation of the character onto the stack
            	}
            } 
        return stack.empty();
    }
}


