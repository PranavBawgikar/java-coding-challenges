/*E
Challenge: Armstrong Number between two Intervals
An Armstrong number is a number that is equal to the sum of its digits raised to the power of the number of digits.
12 = 1^2 + 1^2 = 5
153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
*/
import java.lang.Math;
public class Armstrong{
	public static void main(String[] args) {
		int n = 0; //Represents the number of digits in a number
		double result = 0; //Represents the sum of digits raised to the power of n
		int start = 100, end = 500;
		//Temporary variables for processing the digits of a number
		int temp, r;
		for(int i = start; i <= end; i++){
			temp = i;
			//A while loop that divides temp by 10 and increments n until temp becomes 0.
            //This loop will count the num of digits in the current num by dividing it by 10 repeatedly until it becomes 0.
			while(temp != 0){
				temp = temp / 10;
				++n;
			}
			//Calculate the sum of digits raised to the power of n
			temp = i;
			while(temp != 0){
				r = temp % 10;
				result = result + Math.pow(r, n);
				temp = temp / 10;
			}
			//Checking if the number is an Armstrong number by comparing the result with the current num i
			if(result == i){
				System.out.println(result);
			}
			//Reset n and result to 0 to prepare for the next iteration of the outer loop
			n = 0;
			result = 0;
		}
	}
}