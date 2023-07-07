/*
Challenge: Elimination week in BIG BOSS HOUSE
Assume you are the big boss, and you need to choose the house captain for this week, but in a mathematical way with some sieving techniques applied.
You have given the contestants a number starting at one and asked them to stand in increasing order.

THE GAME BEGINS RIGHT NOW...!

In the first round, starting from left to right, remove the first number and every alternate number till the end of the list.
In the second round, repeat the previous step again, but this time, from right to left, remove the rightmost number and every alternate number from the list.
Keep repeating the steps again, alternating from left to right and from right to left, until only one number remains.
Given the integer n, which represents the number of housemates, write a code to return the number of the contestant who lasts in this and is going to be the house captain this week.

Example
Input:
n = 9

Output:
6

Explanation:
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
arr = [2, 4, 6, 8]
arr = [2, 6]
arr = [6]

Input format :
The input consists of an integer representing the number of housemates (n).

Output format :
The output prints the number of the contestant who is going to be the captain of the week.

Sample test cases :
Input 1 :
9
Output 1 :
6
Input 2 :
15
Output 2 :
8
*/

import java.util.Scanner ;

class BiggBoss {
    public static int lastRemaining(int n){ //Takes the number of housemates as input
        boolean left = true; //To determine the direction of elimination i.e., L-R or R-L
        int remaining = n; //Keeps track of the remaining contestants
        int step = 1; //Represents the distance between two consecutive contestants to be eliminated
        int head = 1; //Represents the first contestant in the current round
        while (remaining > 1){ //To simulate the process of elimination until only one contestant is left
            if (left || remaining % 2 ==1){ //To check if the elimination starts from left
                head = head + step ;
            }
            remaining = remaining / 2; //To represent the reduced number of contestants in the next round
            step = step * 2;
            left = !left;
        }
        return head ;
    }
	public static void main(String[] args){
	    Scanner sc = new Scanner(System.in) ;
	    int n = sc.nextInt() ;
	    System.out.print(lastRemaining(n)) ;
	}
}