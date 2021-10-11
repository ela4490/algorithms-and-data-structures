/* Given the root of a binary tree, return the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root. The length of a path between two nodes is represented by the number of edges between them.

Example 1:
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:
Input: root = [1,2]
Output: 1

Constraints:
The number of nodes in the tree is in the range [1, 10^4].
-100 <= Node.val <= 100
    
Link: https://leetcode.com/problems/diameter-of-binary-tree/ */

//Iterative Approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        int diameter = 0;
        
        if(root!=null) {
            stack.push(root);
        }
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();
            
            if(node.left!=null && !map.containsKey(node.left)) {
                stack.push(node.left);
            } else if(node.right!=null && !map.containsKey(node.right)) {
                stack.push(node.right);
            } else {
                stack.pop();
                int leftDepth = map.getOrDefault(node.left, 0);
                int rightDepth = map.getOrDefault(node.right, 0);
                map.put(node, 1 + Math.max(leftDepth, rightDepth));
                diameter = Math.max(diameter, leftDepth + rightDepth);
            }
            
        }
        
        return diameter;
    }
}

//Recursive Approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int current = depth(root.left) + depth(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        
        return Math.max(current, Math.max(left, right));
    }
    
    private int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}