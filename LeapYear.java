import java.util.Scanner;

public class LeapYear {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean leap = false;
		int year = s.nextInt();

		if(year % 4 == 0) {
			if(year % 100 == 0) {
				if(year % 400 == 0) {
					leap = true;
				} else {
					leap = false;
				}
			} else {
				leap = true;
			}
		} else {
			leap = false;
		}

		if(leap) {
			System.out.println("It is a Leap Year");
		} else {
			System.out.println("It is not a Leap Year");
		}
	}
}