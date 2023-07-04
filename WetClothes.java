/*
Challenge: Wet Clothes (Source: HackerEarth)
We have got m completely wet clothes out under sunshine waiting to become dry.
We are now at second t1 and it's raining. It's going to rain again on seconds t2...tn and after each rain clothes will be completely wet again.
Cloth number i needs a[i] seconds to dry. We can go out and collect all dry clothes at any moment but can't do this more than g times.
What is the maximum number of clothes we can collect until second t[n]? Note that the duration of each rain is almost zero, so we can ignore it.
Also collecting clothes does not take any time from us.

Input Format:
First line of input contains three integers n, m, g

Output Format:
In a single line print maximum number of clothes we can print.
*/

import java.util.Scanner;

public class WetClothes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input values
        int n = scanner.nextInt(); // Number of rains
        int m = scanner.nextInt(); // Number of clothes
        int g = scanner.nextInt(); // Maximum number of times clothes can be collected

        // Read the durations of each rain
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = scanner.nextInt();
        }

        // Read the time needed for each cloth to dry
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }

        int res = 0; // Maximum number of clothes we can collect
        int maxDry = 0; // Maximum time needed for a cloth to dry

        // Find the maximum time difference between consecutive rains
        for (int i = 1; i < n; i++) { //Loop through the durations of rains
            maxDry = Math.max(maxDry, t[i] - t[i - 1]);
        }

        //The loop iterates over the array a and checks if each cloth's drying time is less than or equal to the maximum time needed for a cloth to dry (maxDry). 
        //If it is, the cloth can be collected, and the res variable is incremented to keep track of the maximum number of clothes that can be collected before the next rain.
        for (int i = 0; i < m; i++) {
            if (a[i] <= maxDry) {
                res++;
            }
        }

        // Print the maximum number of clothes we can collect
        System.out.println(res);
    }
}
