/*M
Challenge: Mine Diffusion: Subarray Key Count
As our mighty hero Hulk sucks in the land of mines. In order to escape from the land of mines, Hulk needs to neutralize all the mines in his path. 
Individual mine consisted of an array of integers with a separate individual integer k written on it and a space above which “key” was written.
In order to diffuse a mine, Hulk needs to find a key. 
The key is to diffuse the bomb. 
To diffuse a mine, Hulk needs to find the count of all the subarrays that contain k or more than k similar elements.
Since Hulk is weak at calculations, help Hulk calculate the key in order to diffuse individual mines. 

Input format :
The first line contains the integers n (size of the array) and k separated by space.
The second line contains an array of integers separated by space. 

Output format :
Output prints the number of subarrays.

Code constraints :
1<=n<=10^5
1<=ai<=10^9
1<=k<=10^5

Sample test cases :
Input 1:
4 2
4 3 4 3

Output 1:
3
*/

import java.util.Scanner;

public class MineDiffusion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the size of the array and k
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        // Read the array elements
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int count = 0; //To store the final count of subarrays
        for (int i = 0; i < n; i++) { //This loop iterates over the starting index of the subarray
            int freq = 0;
            for (int j = i; j < n; j++) { //And this loop iterates over the end index
                if (arr[j] == arr[i]) {
                    freq++; //This is to keep track of the number of elements in the subarray that have the same value
                }
                if (freq >= k) { //It true, it means that the current subarray contains k or more than k similar elements	
                    count++;
                }
            }
        }
        
        System.out.println(count);
        
        scanner.close();
    }
}