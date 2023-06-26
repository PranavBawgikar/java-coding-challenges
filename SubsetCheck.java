/*
Challenge: Set Subset Check 
Find whether an array is subset of another array, The two arrays are given as arrl [0..m-1] and arr2 [0..n-1]. Find whether arr2 [ ] is a subset of arrl [ ] or not. Both arrays are not in sorted order. It may be assumed that elements in both arrays are distinct.

For example,
The input is arr[] = {11, 1, 13, 21, 3, 7}, arr2 [ ] = {11, 3, 7, 1}. The output is arr2 [ ] is a subset of arrl [ ]

Input format:
The first line of input contains an integer m, which is the size of arrl. The second line contains m integers separated by spaces, which are the elements of arrl.
The third line contains an integer n, which is the size of arr2.
The fourth line contains n integers separated by spaces, which are the elements of arr2.

Output format:
The output displays whether arr2 is a subset of arrl or not. If arr2 is a subset of arrl, it will print "arr2 [ ] is a subset of arr1[]". Otherwise, it will print "arr2 [ ] is not a subset of arrl [ ]"
Refer to the sample input and output for formatting specifications.

Sample test cases:
Input 1:
5
1 2 3 4 5
3
1 3 5

Output 1:
arr2[] is subset of arr1[] 
*/

import java.util.*;

public class SubsetCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the size of arr1
        int m = scanner.nextInt();
        
        // Read the elements of arr1
        int[] arr1 = new int[m];
        for (int i = 0; i < m; i++) {
            arr1[i] = scanner.nextInt();
        }
        
        // Read the size of arr2
        int n = scanner.nextInt();
        
        // Read the elements of arr2
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = scanner.nextInt();
        }
        
        // Convert arr1 and arr2 to sets for easy comparison
        //Creating two empty sets, set1 and set2, using the HashSet class. 
        //The HashSet class implements the Set interface and provides a collection that contains no duplicate elements.
        Set<Integer> set1 = new HashSet<>();
        for (int num : arr1) { //enchanced for-loop to iterate over each element in arr1
            set1.add(num); //adding each unique element to set1 using the add() method
        }
        
        Set<Integer> set2 = new HashSet<>();
        for (int num : arr2) {
            set2.add(num);
        }
        
        // Check if set2 is a subset of set1
        boolean isSubset = set1.containsAll(set2);
        
        // Print the result
        if (isSubset) {
            System.out.println("arr2[] is a subset of arr1[]");
        } else {
            System.out.println("arr2[] is not a subset of arr1[]");
        }
    }
}