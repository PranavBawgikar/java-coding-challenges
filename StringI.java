/*
Challenge: Remove Special Characters from String
Given a string remove all special characters from the string.

Input: $ja!va$&st%ar
Output: javastar
*/
import java.util.Scanner;
public class StringI {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		System.out.println(approach1(str));
	}

	//Approach 1 - replaceAll(str)
	public static String approach1(String str) {
		str = str.replaceAll("[^a-zA-Z0-9]", ""); //`^` denotes `any thing other than`
		return str;
	}
}