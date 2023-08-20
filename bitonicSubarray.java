/*
Challenge: Longest Bitonic Subarray
Ram is an intelligent programmer and very good at arrays. He is given with subarray problem. 
The problem statement is to discover a subarray of a given series wherein the subarray’s elements are first sorted in increasing order, 
then in decreasing order, and the subarray is as long as possible. Strictly ascending or descending subarrays also are accepted.

Input format :
The first line of the input is the size of the array, N.
The second line of the input consists of the array of elements separated by space.

Output format :
The output displays the length of the longest subarray along with the elements.

Sample test cases :
Input 1 :
7
4 5 6 8 9 7 5

Output 1 :
The length of the longest bitonic subarray is 7
The longest bitonic subarray is [4, 5, 6, 8, 9, 7, 5]

Input 2 :
10
1 2 3 4 5 6 7 8 9 10

Output 2 :
The length of the longest bitonic subarray is 10
The longest bitonic subarray is [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Examples of bitonic subarrays:
4 5 6 7 8 9 7 5 //The array increases upto a peak and then starts to decrease
4 5 6 7 8 9 11 13 //Valid bitonic array since it's strictly increasing array
15 13 11 9 8 7 6 5 //Valid bitonic array since it's strictly decreasing array
7 8 7 5 3 2 1   
*/

import java.util.Scanner;
import java.util.Arrays;

public class bitonicSubarray {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        
        int maxLength = 1; //Keeps track of the length of the longest bitonic subarray found so far
        int currentLength = 1; //Represents the length of the current subarray being considered
        int end = 0; //Stores the ending index of the longest bitonic subarray
        int start = 0; //Stores the starting index of the longest bitonic subarray
        boolean increasing = true; //Flag that indicates whether the current subarray is increasing or decreasing
        
        for(int i = 1; i < n; i++) {
            if(arr[i] > arr[i - 1]) {
                if(!increasing) {
                    currentLength = 1;
                }
                
                currentLength++;
                increasing = true;
                
            } else if(arr[i] < arr[i - 1]) {
                currentLength++;
                increasing = false;
            } else {
                currentLength = 1;
            }
            
            if(currentLength > maxLength) {
                maxLength = currentLength;
                start = i - maxLength + 1;
                end = i;
            }
        }
        
        System.out.println("The length of the longest bitonic subarray is " + maxLength);
        System.out.println("The longest bitonic subarray is [");
        for(int i = start; i <= end; i++) {
            System.out.print(arr[i]);
            if(i != end) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}