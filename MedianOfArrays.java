/*
Challenge: Median of Two Sorted Arrays
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

Example
Input
2
1 2
2
3 4

Output
2.5

Explanation
merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5

Input format :
The first line contains an integer m (1 ≤ m ≤ 1000), representing the size of the first sorted array nums1.
The second line contains m integers separated by a space, representing the elements of the first sorted array nums1 in non-descending order.
The third line contains an integer n (1 ≤ n ≤ 1000), representing the size of the second sorted array nums2.
The fourth line contains n integers separated by a space, representing the elements of the second sorted array nums2 in non-descending order.

Output format :
The output contains a single decimal number, representing the median of the two sorted arrays.
If the combined length of the two arrays is even, then the median is the average of the two middle elements.
Otherwise, it is the middle element. The output should be accurate up to one decimal place.

Code constraints :
nums1.length = m
nums2.length = n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
The overall runtime complexity should be O(log (m+n)).
*/

import java.util.Scanner ;

class MedianOfArrays{
    
    static double findMedianOfSortedArrays(int nums1[], int m, int nums2[], int n) { //Accepts two sorted arrays and their respective sizes
        int N1 = m;
        int N2 = n;
        if (N1 < N2) return findMedianOfSortedArrays(nums2, n, nums1, m); //Comparing the sizes of the arrays to ensure that nums2 is the shorter array here for simpler subsequent calculations
    
        int lo = 0, hi = N2 * 2; //These variables will be used for binary search to find the median
        while (lo <= hi) {
        	//mid 2 and mid1 are used to partition the array
            int mid2 = (lo + hi) / 2;
            int mid1 = N1 + N2 - mid2;
            
            double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1-1)/2]; //Left Half of nums1, it represnts maximum element of the left side of the nums1
            //(mid1-1)/2 index represents the last element of the left half of nums1
            double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2-1)/2];
            double R1 = (mid1 == N1 * 2) ? Integer.MAX_VALUE : nums1[(mid1)/2]; //Right Half of nums1, represents the minimum element on the right side of nums1
            //(mid1)/2 index represents the first element of the right half of nums1
            double R2 = (mid2 == N2 * 2) ? Integer.MAX_VALUE : nums2[(mid2)/2];
            
            if (L1 > R2) lo = mid2 + 1;	//It means that the lower half of nums1 is too big and needs to move the partition C1 to the left (C2 to the right)
            else if (L2 > R1) hi = mid2 - 1;//the lower half of nums2 is too big and needs to move the partition C2 to the left
            else return (Math.max(L1,L2) + Math.min(R1, R2)) / 2;	// Otherwise, that's the right cut
            //Returns the median, which is the average of the maximum value between L1 and L2 and the minimum value between R1 and R2
        }
        return -1 ;
    }   
    
    public static void main(String a[]){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt() ;
        int nums1[] = new int [m] ;
        for(int i = 0 ; i < m ; i++)
            nums1[i] = sc.nextInt() ;
        int n = sc.nextInt() ;
        int nums2[] = new int[n] ;
        for(int i = 0 ; i < n ; i++)
            nums2[i] = sc.nextInt() ;
            
        System.out.print(findMedianOfSortedArrays(nums1, m, nums2, n));
    }
}