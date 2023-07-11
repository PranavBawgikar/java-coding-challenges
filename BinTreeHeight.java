/*
Challenge: Binary Tree Height Calculation
Given an array representing the parent-child relationship in a binary tree, find the tree's height without building it. The parent-child relationship is defined by (A[i], i) for every index i in the array. The root node's value will be i if -1 is present at index i in the array.

The depth of a node is the total number of edges from the node to the tree's root node. The root is the only node whose depth is 0. The height of a node is the total number of edges on the longest path from the node of a leaf. The height of a tree would be the height of its root node or equivalently the depth of its deepest node. A leaf node will have a height of 0.

Example:
Parent: [-1, 0, 0, 1, 2, 2, 4, 4]
Index: [0, 1, 2, 3, 4, 5, 6, 7]

-1 is present at index 0, which implies that the binary tree root is node 0.
0 is present at index 1 and 2, which implies that the left and right children of node 0 are 1 and 2.
1 is present at index 3, which implies that the left or the right child of node 1 is 3.
2 is present at index 4 and 5, which implies that the left and right children of node 2 are 4 and 5.
4 is present at index 6 and 7, which implies that the left and right children of node 4 are 6 and 7.

Input format :
The first line contains a single integer n, which represents the number of nodes in the tree.
The next lines of input consist of n integers, where the last line of input consists of the i-th integer representing the parent of the i-th node. If the i-th node is the root node, then the corresponding value will be -1.

Output format :
The output consists of a single integer, which represents the height of the tree.

Sample test cases :
Input 1 :
8
-1
0
0
1
2
2
4
4

Output 1 :
3

Input 2 :
4
-1
0
1
1

Output 2 :
2
*/

import java.util.Scanner;

public class BinTreeHeight { //Calculates the depth of a node in the tree
    public static int findDepth(int[] parent, int i) { //`parent` array and index `i` of the current node
        if (parent[i] == -1) { //It indicates that it is the root node and the depth is 0
            return 0;
        }
        //Else the depth is calculated recursively by adding 1 to the depth of the parent node
        return 1 + findDepth(parent, parent[i]);
    }

    public static int findHeight(int[] parent) { //To find the height of the tree
        int height = -1;
        for (int i = 0; i < parent.length; i++) {
            height = Math.max(height, findDepth(parent, i));
        }
        return height;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //Number of nodes in the tree
        int[] parent = new int[n]; //Represents the parent index of each node
        for (int i = 0; i < n; i++) {
            int ele = scanner.nextInt();
            parent[i] = ele;
        }
        System.out.println(findHeight(parent));
    }
}
