/*
Challenge: Reverse an Array in Groups Using ArrayList
Given an array of integers and a size K, reverse every subarray of K group elements.

Example 1:
Input: {1, 5, 7, 2, 3, 6, 7, 8, 9}
K = 3

Ouput: {7, 5, 1, 6, 3, 2, 9, 8, 7}

Example 2:
Input: {1, 2, 3, 4, 5, 6, 7, 8}
K = 5

Output: {5, 4, 3, 2, 1, 8, 7, 6}
*/
import java.util.Scanner;
import java.util.ArrayList;

public class ReverseArrayInGroups2 {

	public static ArrayList<Integer> reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        int len = arr.size();
        for(int i = 0; i < len; i = i + k) {
            int start = i;
            int end = Math.min(i + k - 1, len - 1);
            
            while(start <= end) {
                int temp = arr.get(start);
                arr.set(start, arr.get(end));
                arr.set(end, temp);
                start++;
                end --;
            }
        }
        return arr;
    }

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<Integer> arrList = new ArrayList<>();

		for(int i = 0; i < n; i++) {
			arrList.add(s.nextInt());
		}

		int k = s.nextInt();

		ArrayList<Integer> result = new ArrayList<>();
		result = reverseInGroups(arrList, n, k);

		for(int i = 0; i < n; i++) {
			System.out.print(arrList.get(i) + " ");
		}
	}
}