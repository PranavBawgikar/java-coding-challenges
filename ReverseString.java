/*
Challenge: Reverse String Using Array in Java
Method 1: Making use of a character array
To reverse a string, the easiest technique is to convert it to a character array and then swap the characters at both ends of the array.

Method 2: Making Use of StringBuilder
The StringBuilder class is another technique to reverse a string in Java.

Method 3: Recursion
Recursion can also be used to reverse a string.
*/
import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		String result = reverseString(str);
		System.out.println(result);
	}

	//Method 1
	public static String reverseString(String str) {
		char[] charArray = str.toCharArray();
		int left = 0;
		int right = charArray.length - 1;
		while(left < right) {
			char temp = charArray[left];
			charArray[left] = charArray[right];
			charArray[right] = temp;
			left++;
			right--;
		}
		return new String(charArray);
	}

	//Method 2
	public static String reverseString(String str) {
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();
	}

	//Method 3
	public static String reverseString(String str) {
		if(str.isEmpty()) {
			return str;
		}

		return reverseString(str.substring(1)) + str.charAt(0);
	}
}