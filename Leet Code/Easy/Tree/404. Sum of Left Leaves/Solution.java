/* Given the root of a binary tree, return the sum of all left leaves.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.

Example 2:
Input: root = [1]
Output: 0

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-1000 <= Node.val <= 1000
    
Link: https://leetcode.com/problems/sum-of-left-leaves/ */

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
    
    private int total = 0;
    
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        sumHelper(root, false);
        return total;
    }
    
    private void sumHelper(TreeNode root, boolean isLeft) {
        if(root == null) {
            return;
        }
        
        if(isLeft && root.left == null && root.right == null) {
            total += root.val;
        }
        
        sumHelper(root.left, true);
        sumHelper(root.right, false);
        
        return;
    }
}