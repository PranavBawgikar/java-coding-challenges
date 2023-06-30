/*
Challenge: Minimum Value in Array
*/
import java.util.Scanner;
public class MinValInArr{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the array length:");
		int n = s.nextInt();
		System.out.println("Enter the array elements:");
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = s.nextInt();
		}
		int result = findMinVal(arr, n);
		System.out.println("Your minimum value is "+ result);
	}

	static int findMinVal(int[] arr, int n){
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++){
			if(arr[i] < min){
				min = arr[i];
			}
		}
		return min;
	}
}