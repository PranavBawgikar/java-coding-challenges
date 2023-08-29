/*
Challenge: Convert Decimal to Binary
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class DecToBin {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i;
		int[] arr = new int[10];

		if(n == 0) {
			System.out.println(0);
		}

		for(i = 0; n > 0; i++) {
			arr[i] = n % 2;
			n = n / 2;
		}

		for(i = i - 1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
	}
}