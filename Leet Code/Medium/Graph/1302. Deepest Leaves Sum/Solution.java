/* Given the root of a binary tree, return the sum of values of its deepest leaves.

Example 1:
Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15

Example 2:
Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19

Constraints:
The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 100

Link: https://leetcode.com/problems/deepest-leaves-sum/ */

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
    public int deepestLeavesSum(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int level_sum = 0;
        q.add(root);
        while(!q.isEmpty()){
            level_sum = 0;
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode current = q.poll();
                level_sum += current.val;
                if(current.left!=null) q.offer(current.left);
                if(current.right!=null) q.offer(current.right);
            }
        }
        return level_sum;
    }
}