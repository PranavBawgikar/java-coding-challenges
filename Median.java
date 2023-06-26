/*
Challenge: Median Calculation
The method median accepts an integer array, arr. It is supposed to calculate and return the median of the elements in the input array.
Note: Print the answer with 6 floating points

Input format:
The first line of input consists of the size of the array. The next line consists of the space-separated array elements.

Output format:
The output prints the median of the given array.
Refer to the sample output for formatting specifications.

Sample test cases:
Input 1:
5
1 2 3 4 5

Output 1:
3.000000

Input 2:
4
1 2 3 4

Output 2:
2.500000
*/

import java.util.Arrays;
import java.util.Scanner;

public class Median {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        double median = calculateMedian(arr);
        System.out.printf("%.6f", median);
    }

    public static double calculateMedian(int[] arr) {
        Arrays.sort(arr); //sorting the array in ascending order, necessary to find the median
        int size = arr.length;
        if (size % 2 == 0) { //checking the size of the array whether even or odd	
            int mid1 = arr[size / 2 - 1];
            int mid2 = arr[size / 2];
            return (double) (mid1 + mid2) / 2;
        } else {
            return arr[size / 2];
        }
    }
}