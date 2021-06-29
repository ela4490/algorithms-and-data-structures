/* Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

Example 1:
Input: root = [4,2,6,1,3]
Output: 1

Example 2:
Input: root = [1,0,48,null,null,12,49]
Output: 1

Constraints:
The number of nodes in the tree is in the range [2, 10^4].
0 <= Node.val <= 10^5

Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
    
Link: https://leetcode.com/problems/minimum-absolute-difference-in-bst/ */

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
    public int getMinimumDifference(TreeNode root) {
        if(root==null) return 0;
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(root, list);
        for(int i=1; i<list.size(); i++){
            min = Math.min(min, Math.abs(list.get(i-1)-list.get(i)));
        }
        return min;
    }
    private void dfs(TreeNode root, ArrayList<Integer> list){
        if(root==null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
