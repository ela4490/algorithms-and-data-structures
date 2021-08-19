/* Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized. Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7. Note that you need to maximize the answer before taking the mod and not after taking it.

Example 1:
Input: root = [1,2,3,4,5,6]
Output: 110
Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)

Example 2:
Input: root = [1,null,2,3,4,null,null,5,6]
Output: 90
Explanation: Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)

Example 3:
Input: root = [2,3,9,10,7,8,6,5,4,11,1]
Output: 1025

Example 4:
Input: root = [1,1]
Output: 1

Constraints:
The number of nodes in the tree is in the range [2, 5 * 10^4].
1 <= Node.val <= 10^4

Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3903/ */

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
    
    private long totalSum = 0;
    private long maxProduct = 0;
    
    public int maxProduct(TreeNode root) {
        dfs(root);
        calculateSubTreeSum(root);
        return (int)(maxProduct%((int)Math.pow(10, 9) + 7));
    }
    
    private void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        dfs(root.right);
        totalSum += (long)root.val;
    }
    
    private long calculateSubTreeSum(TreeNode root){
        if(root==null) return 0;
        long l = calculateSubTreeSum(root.left);
        long r = calculateSubTreeSum(root.right);
        long subTreeSum = l + r + root.val;
        maxProduct = Math.max(maxProduct, (subTreeSum * (totalSum-subTreeSum)));
        return subTreeSum;
    }
}