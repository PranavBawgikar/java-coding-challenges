/*
Challenge: Pascal's Triangle (Source: LeetCode)
Given a non-negative integer numRows, generate the first numRows of pascals triangle.
In Pascal's triangle each number is the sum of the two numbers directly above it.

Input: 5
Output:
[
    [1],
   [1, 1],
  [1, 2, 1],
 [1, 3, 3, 1],
[1, 4, 6, 4, 1]
]
*/
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class PascalTri{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of rows: ");
		int numRows = s.nextInt();
		List<List<Integer>> triangle = generate(numRows);
        printTriangle(triangle);
	}

	public static List<List<Integer>> generate(int numRows){
		List<List<Integer>> triangle = new ArrayList<>();
		if(numRows == 0) return triangle;
		List<Integer> first_row = new ArrayList<>();
		first_row.add(1);
		triangle.add(first_row);

		for(int i = 1; i < numRows; i++){
			List<Integer> prev_row = triangle.get(i - 1);
			List<Integer> curr_row = new ArrayList<>();
			System.out.println();
			curr_row.add(1);

			for(int j = 1; j < i; j++){
				curr_row.add(prev_row.get(j - 1) + prev_row.get(j));
			}

			curr_row.add(1);
			triangle.add(curr_row);
		}
		return triangle;
	}

	public static void printTriangle(List<List<Integer>> triangle) {
        for (List<Integer> row : triangle) {
            for (Integer num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}