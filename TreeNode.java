/*
Challenge: Invert a Binary Tree (Source: HackerEarth)
          6
        /    \
       /      \
      /        \
     /          \
   5(1)        1(5)
  /    \      /    \
2(6)  8(9)  9(8)  6(2)

Explanation: When we swap 5 and 1 say from the above given binary tree, we're not just swap those two numbers/nodes on that level.
Instead every sub-tree for/below that node gets swapped with that node.
We just have to go to each level and repeat the same process of swapping.
*/

class TreeNode {
    int val;
    TreeNode left; //Reference to left child
    TreeNode right; //Referce to right child

    TreeNode(int val) {
        this.val = val;
    }
}
//It follows DFS approach
public class InvertBinaryTree {
    public TreeNode invert(TreeNode root) {
        if (root == null) { //Best case for recursion when root node is null, indicating an empty tree or leaf node
            return root;
        }
        //Swapping the left and right child node of the current nodes
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invert(root.left); //Recursively called by the current node to inevert their respective sub-trees
        invert(root.right);
        
        return root;
    }
}
