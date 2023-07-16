/*
Challenge: Calculating Gain Percentage
Vikram buys an old scooter for Rs. A and spends Rs. B on its repairs. If he sells the scooter for Rs. C , what is his gain %?
Write a program to compute the gain %.

Input format :
First line of the input consists of the price of the scooter.
Second line of the input consists of the repair charges.
Third line of the input consists of the selling price.

Output format :
Output prints the gain percentage. Round off the output to two decimal places.

Sample test cases :
Input 1 :
4700
800
5800

Output 1:
5.45
*/
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
class Gainpercentage {
	public static void main(String [] args) {
		int price,repair,sp,cp,gain;
		double gainpercent;
		DecimalFormat d = new DecimalFormat("0.00"); //Rounding off the decimal places to 2
		Scanner sc = new Scanner(System.in);
		price = sc.nextInt();
		repair = sc.nextInt();
		sp = sc.nextInt();
		cp = price + repair;
		gain = sp - cp; //Profit 
		gainpercent = ((double)gain/(double)cp) *100;
		System.out.println(d.format(gainpercent));
	}
}
