/* Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it. If the tree has more than one mode, return them in any order. Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [1,null,2,2]
Output: [2]

Example 2:
Input: root = [0]
Output: [0]

Constraints:
The number of nodes in the tree is in the range [1, 10^4].
-10^5 <= Node.val <= 10^5
 
Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
    
Link: https://leetcode.com/problems/find-mode-in-binary-search-tree/ */

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
    Integer prev = null;
    int count = 1;
    int max = 0;
    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList();
        traverse(root, modes);
        int[] result = new int[modes.size()];
        for(int i=0; i<modes.size(); i++){
            result[i] = modes.get(i);
        }
        return result;
    }
    private void traverse(TreeNode root, List<Integer> modes){
        if(root==null) return;
        traverse(root.left, modes);
        if(prev!=null){
            if(prev == root.val){
                count++;
            }else{
                count = 1;
            }
        }
        if(count>max){
            max = count;
            modes.clear();
            modes.add(root.val);
        }else if(count==max){
            modes.add(root.val);
        }
        prev = root.val;
        traverse(root.right, modes);
    }
}