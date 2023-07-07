/*
Challenge: Trade Fair
Trade Fairs are important for companies to present their products and to get in touch with its customers and business parties. One such grandeur Trade Fair Event was organized by the Confederation of National Large Scale Industry.
Number of people who attended the event on the first day was x. But as days progressed, the event gained good response and the number of people who attended the event on the second day was twice the number of people who attended on the first day. Unfortunately due to heavy rains on the third day, the number of people who attended the event was exactly half the number of people who attended on the first day.

Given the total number of people who have attended the event in the first 3 days, find the number of people who have attended the event on day 1, day 2 and day 3.

Input format :
First line of the input is an integer value that corresponds to the total number of people.

Output format :
First line of the output should display the number of attendees on day 1.
Second line of the output should display the number of attendees on day 2.
Third line of the output should display the number of attendees on day 3.

Sample test cases:
Input 1:
10500

Output 1:
Number of attendees on day 1 : 3000
Number of attendees on day 2 : 6000
Number of attendees on day 3 : 1500
*/
import java.util.*;
import java.io.*;
class Tradefair {
	public static void main(String [] args) {
		int total,day1,day2,day3;
		Scanner sc = new Scanner(System.in);
		total = sc.nextInt();
		day1 = (total*2)/7;
		day2 = day1*2;
		day3 = day1/2;
		System.out.println("Number of attendees on day 1 : "+day1);
		System.out.println("Number of attendees on day 2 : "+day2);
		System.out.println("Number of attendees on day 3 : "+day3);
	}
}
