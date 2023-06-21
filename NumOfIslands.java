/*
Challenge: Number of Islands (Source: LeetCode)
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.
Example Input:
11110
11010
11000
00000
Example Output:
1

Hints: The code counts the number of islands in a grid by using a recursive approach called Breadth-First Search (BFS). 
It explores the grid, starting from each '1' cell, and marks all the connected '1' cells as visited until no more islands are found. 
The count is incremented for each discovered island.
*/
public class NumOfIslands{
	public static void main(String[] args) {
		
	}
	public int numIslands(char[][] grid){ //a grid map of 1s and 0s
		int count = 0; //used to keep track of number of islands
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if(grid[i][j] == '1'){
					count += 1;
					callBFS(grid, i, j);
				}
			}
		}
		return count; //returns the count of islands
	}
	public void callBFS(char[][] grid, int i, int j){
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
			return;
			grid[i][j] = '0';
			callBFS(grid, i + 1, j); //check up
			callBFS(grid, i - 1, j); //check down
			callBFS(grid, i, j - 1); //check left
			callBFS(grid, i, j + 1); //check right
	}
}