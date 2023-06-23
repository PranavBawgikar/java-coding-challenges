/*
Challenge: Possible Number of Decodings
Let 'A' represent 1, 'B' represent 2, and so on,

Input: 123
Output: 3
123 -> 1 2 3 (ABC)
       12 3  (LC)
       1 23  (AW)
*/
import java.util.Scanner;
import java.lang.String;
class PossibleDecodings{
	public static void main(String[] args) {
		String digits;
		Scanner s  = new Scanner(System.in);
		System.out.println("Enter the digits: ");
		digits = s.nextLine();
		int n = digits.length();
		System.out.println(decodings(digits, n));
	}

	static int decodings(String digits, int n){
		int[] count = new int[n + 1];
		count[0] = 1;
		count[1] = 1;
		for(int i = 2; i <= n; i++){
			count[i] = 0;
			if(digits.charAt(i - 1) > '0')
				count[i] = count[i - 1];
			if(digits.charAt(i - 2) == '1' || (digits.charAt(i - 2) == '2' && digits.charAt(i - 1) < '7'))
				count[i] += count[i - 2];
		}
		return count[n];
	}
}