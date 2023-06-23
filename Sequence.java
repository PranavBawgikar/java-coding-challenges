/*
Challenge: Cummulative Sum and Multiplication Sequence
Input: 8 4 5 3 2 6 9 1
Output: 189 120 90 45 15 9 0 0

8 -> 4+5+3+2+6+1 = 21
21 * 9 = 189

4 -> 3+2+1 = 6
6 * 20 (5+6+9) = 120
*/
public class Sequence{
	public static void main(String[] args) {
		int a[] = {8, 4, 5, 3, 2, 6, 9, 1};
		int n = 8;
		int[] result = getProduct(a, n);
		for(int i = 0; i < n; i++)
			System.out.print(result[i]  + " ");
	}

	static int[] getProduct(int a[], int n){
		if(n == 0)
			return a;
		for(int i = 0; i < n; i++){
			int sumOfLargeNum = 0;
			int sumOfSmallNum = 0;
			for(int j = i + 1; j < n; j++){
				if(a[j] < a[i]){
					sumOfSmallNum = sumOfSmallNum + a[j];
				} else {
					sumOfLargeNum = sumOfLargeNum + a[j];
				}
			}
			a[i] = (sumOfSmallNum * sumOfLargeNum);
		}
		return a;
	}
}