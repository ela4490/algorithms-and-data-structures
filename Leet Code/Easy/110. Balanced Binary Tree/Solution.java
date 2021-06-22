/* Given a binary tree, determine if it is height-balanced. For this problem, a height-balanced binary tree is defined as: A binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true

Constraints:
The number of nodes in the tree is in the range [0, 5000].
-10^4 <= Node.val <= 10^4
    
Link: https://leetcode.com/problems/balanced-binary-tree/ */

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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return (Math.abs(height(root.left)-height(root.right))<2) && isBalanced(root.left) && isBalanced(root.right);
    }
    private int height(TreeNode root){
        if(root==null) return -1;
        return 1+Math.max(height(root.left), height(root.right));
    }
}