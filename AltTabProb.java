/*
Challenge: ALT-TAB Window Problem/K Most Recently Used Apps
Input: arr[] = {3, 5, 2, 4, 1}, K = 3

Output: 4 3 5 2 1

Given an integer K and an array arr[] of N integers which contains the ids of the opened aps in a system where
1. arr[0] is the app currently in use
2. arr[1] is the app which was most recently used and 
3. arr[N - 1] is the app which was least recently used

The task is to print the contents of the array when the user using the system presses Alt+Tab exactly K number of times.
Note that after pressing Alt+Tab key, app opening pointer will move through apps from 0th index towards right, 
depending upon the number of presses, so the app on which the press ends will shift to 0th index, 
because that will become the most recently opened app.
*/

	public class AltTabProb{
		public static void main(String[] args) {
			int a[] = {3, 5, 2, 4, 1};
			int n = a.length;
			int k = 3;
			int result[] = AltTab(a, n, k);
			for(int i = 0; i < n; i++){
				System.out.print(result[i] + " ");
			}
		}

		static int[] AltTab(int a[], int n, int k){
			int index = 0;
			index = k % n; //calculates the index after 'K' presses i.e., K = 3, 3 % 5 = 3
			int x = index; //'x' is the position of the following 'id'
			int id = a[index];
			while(x > 0){
				int p = x;
				x--;
				a[p] = a[x];
			}
			a[0] = id;
			return a;
		}
	}