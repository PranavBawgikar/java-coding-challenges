/*
Challenge: Name Abbreviation
Bob is teaching the alphabet to the students. After the English class, the computer class starts. So, students had thought of doing a task for converting a person's name into an abbreviated one.

For example,
The inputs are first name is Gangadher, The middle name is S, The last name is Pavani.
So the output displays the G. S. Pavani

Input format:
The input consists of three strings separated by a space.
Refer to the sample input for format specifications.

Output format:
The output shows a person's converted name.
Refer to the sample input for the formatting specifications.

Sample test cases:
Input 1:
Gangadher S Pavani

Output 1:
G. S. Pavani

Input 2:
G Pratab Yadhav

Output 2:
G. P. Yadhav
*/

import java.util.Scanner;

public class NameAbbreviation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.next();
        String middleName = scanner.next();
        String lastName = scanner.next();
        scanner.close();

        String abbreviatedName = firstName.charAt(0) + ". " + middleName.charAt(0) + ". " + lastName;
        //This line takes the first character of the firstName, adds a dot (.), followed by a space, then adds the first character of the middleName, another dot, a space, and finally, the lastName. 
        //This forms the abbreviated name.
        System.out.println(abbreviatedName);
    }
}
