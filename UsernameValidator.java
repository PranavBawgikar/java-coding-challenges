/*
Challenge: Valid Username Regular Expression (Source: HackerRank)
You are updating the username policy on your company's internal networking platform. According to the policy, a username is considered valid if all the following constraints are satisfied:

The username consists of  to  characters inclusive. If the username consists of less than  or greater than  characters, then it is an invalid username.
The username can only contain alphanumeric characters and underscores (_). Alphanumeric characters describe the character set consisting of lowercase characters , uppercase characters , and digits .
The first character of the username must be an alphabetic character, i.e., either lowercase character  or uppercase character .

Update the value of regularExpression field in the UsernameValidator class so that the regular expression only matches with valid usernames.

Input Format
The first line of input contains an integer , describing the total number of usernames. Each of the next  lines contains a string describing the username. The locked stub code reads the inputs and validates the username.

Output Format
For each of the usernames, the locked stub code prints Valid if the username is valid; otherwise Invalid each on a new line.

Sample Input 0:
8
Julia
Samantha
Samantha_21
1Samantha
Samantha?10_2A
JuliaZ007
Julia@007
_Julia007

Sample Output 0:
Invalid
Valid
Valid
Invalid
Invalid
Valid
Invalid
Invalid
*/
import java.util.Scanner;
class UsernameValidator {
    public static final String regularExpression = "^[A-Za-z]\\w{7,29}$";
}


public class Solution {
    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine()); //Represents the total num of usernames to be validated
        while (n-- != 0) { //Iterates `n` times until the value of `n` becomes 0
            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }           
        }
    }
}

/*Explanation of the regular expression:
`^` indicates start of the line
`[A-Za-z] indicates the first character must be an alphabet either lowercase or upppercase
`\\w` matches any word character (alphanumeric characters and underscore). Equivalent to [a-zA-Z0-9_]
`{7,29}` specifies the length of the username, which must be between 7 and 29 characters (inclusive)
`$` indicates end of the line
*/