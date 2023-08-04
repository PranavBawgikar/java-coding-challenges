/*Binary Search is used for sorted arrays
=> Binary Search Algorithm:
Step #1: First the middle element
Step #2: Check if the target element > middle element, if so search for the element on the RHS of the middle element
		 else, search for the elemnt on the LHS of the middle element
Step #3: If the middle element == target element, DONE

Best Case Scenario: When target element == middle element, i.e., O(1)
Worst Case Scenario: O(log N)
*/
//Method 1: When we know the order of sorting is in ascending order
public class BinarySearch{
	public static void main(String[] args) {
		//Logic for passing the array to the binarySearch method
	}

	//Return the index
	//Return -1 if it does not exist
	public static int binarySearch(int[] arr, int target){
		start = 0;
		end = arr.length - 1;
		while(start <= end){
			// Find the middle element
			// General approach
			// int mid = (start + end) / 2;

			// //If we try to find the `mid` by the above approach there might be a possibility that the (start + end) sum exceed the int capacity in Java so
			// //A better way to find mid
			int mid = start + (end - start) / 2;
			if(target == arr[mid]){
				return mid;
			} else if(target < arr[mid]){
				end = mid - 1; //For the left hand side `start` will point to 0 itself but `end` will change
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
}

//Method 2: Order-Agnostic Binary Search
//Here, we don't know if the given array is sorted in ascending or descending order
public class OrderAgnosticBS {
	public static void main(String[] args) {
		//int[] arr = {-18, -12, -4, -2, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
		int[] arr = {89, 45, 22, 18, 16, 15, 4, 3, 2, 0, -2, -4, -12, -14};
		int target = 3;
		int result = orderAgnosticBS(arr, target);
		System.out.println(result);
	}

	public static int orderAgnosticBS(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;

		//Checking whether the array is ascending or descending
		boolean isAsc = arr[start] < arr[end];
		while(start <= end){
			int mid = start + (end - start) / 2;
			if(target == arr[mid]){
				return mid;
			} 
			if(isAsc) {
				if(target < arr[mid]){
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if(target > arr[mid]){
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return -1;
	}
}