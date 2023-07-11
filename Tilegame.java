/*
Challenge: Tile Game
In connection to the National Mathematics Day celebration, the Regional Mathematical Scholars Society had arranged for a Mathematics Challenge Event where school kids participated in large number. 
Many interesting math games were conducted, one such game that attracted most kids was the tile game where the kids were given 'n' square tiles of the same size and were asked to form the largest possible square using those tiles.
Help the kids by writing a program to find the area of the largest possible square that can be formed, given the side of a square tile (in cms) and the number of square tiles available.

Input format :
First line of the input is an integer that corresponds to the side of a square tile (in cms).
Second line of the input is an integer that corresponds to the number of square tiles available.

Output format :
Output should display the area of the largest possible square that can be formed (in square cms) with the available tiles.

Sample test cases :
Input 1 :
5
8

Output 1:
100
*/
import java.util.*;
import java.io.*;
import java.math.*;
class Tilegame {
	public static void main(String [] args)
	{
		int side,number,i=1,result,area,answer = 0;
		Scanner sc = new Scanner(System.in);
		side = sc.nextInt();
		number = sc.nextInt();
		//result is used to determine the number of tiles needed to form the square
		result = (int) ((int) Math.pow(2, i)*Math.pow(2, i)); //Since the result variable is declared as Integer, we are casting the product of pow() as Integer
		while(result < number) {
			answer = result; //To store the value of `result` from the previous iteration
			i++;
			result = (int) ((int) Math.pow(2, i)*Math.pow(2, i));
		}
		area = side*side;
		System.out.println(area*answer);
	}

}
/*
Using the (int) cast is a way to ensure data type consistency and compatibility when performing calculations involving mixed data types.
*/