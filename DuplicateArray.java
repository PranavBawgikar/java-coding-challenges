/*
Challenge: Find Duplicate Elements in an Array
Input: {1, 5, 4, 2, 1, 4, 7}
Output: {1, 4}

Hint: We are going to use Set Data Structure
Set is an ordered collection of objects in which duplicate values cannot be stored.
Set is an interface and it is implemented by HashSet, LinkedHashSet or TreeSet class.
*/

public class DuplicateArray{
	public static void main(String[] args) {
		int[] arr = {1, 5, 4, 2, 1, 4, 7};

		Set<Integer> uniqueElement = new HashSet<>();
		boolean isDuplicateExist = false;

		for(int i = 0; i < arr.length; i++){
			if(uniqueElement.contains(arr[i])){
				isDuplicateExist = true;
				System.out.println("Duplicate Elements: " + arr[i]);
			} else {
				uniqueElement.add(arr[i]);
			}
		}
		if(!isDuplicateExist){
			System.out.println(-1);
		}
	}
}