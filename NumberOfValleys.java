/*
Challenge: Counting Valleys (Source: Hackerrank)
Complete the countingValleys function in the editor below, it must return an integer that denotes the number of valleys Gary traversed.
countingValleys has the following parameters:
n the number of steps Gary takes
s; a string describing his path

Input Format
The first line contains an integer n, the number of steps in Gary's hike.
The second line contains a single string s, of n characters that describe his path.

Output Format:
Print a single integer that denotes the number of valleys Gary walked through during his hike.
*/

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException; //for handling input/output exceptions

public class NumberOfValleys {

    private static final Scanner scanner = new Scanner(System.in); //This is done to encapsulate the scanner object and ensure that it is only used within the class.

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("[\r\n\u2028\u2029\u0085]+"); //is used to skip any remaining whitespace characters.
        String s = scanner.nextLine();
        int result = countingValleys(n, s);
        System.out.println(result);
        scanner.close();
    }

    static int countingValleys(int a, String s) {
        int altitude = 0; //to keep track of gary's current altitude.
        int num_valleys = 0; //to count the number of valleys Gary traverses.
        for (int i = 0; i < a; i++) {
            if (s.charAt(i) == 'U') { //if the current step is an 'U' (uphill)
                if (altitude == -1) { //if the altitude is -1, it means Gary has come out of a valley, so num_valleys is incremented by 1.
                    num_valleys++;
                }
                altitude++;
            }
            if (s.charAt(i) == 'D') { //if the current step is a 'D' (downhill)
                altitude--;
            }
        }
        return num_valleys;
    }
}
