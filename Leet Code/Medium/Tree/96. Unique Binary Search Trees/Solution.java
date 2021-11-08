/* Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

Example 1:
Input: n = 3
Output: 5

Example 2:
Input: n = 1
Output: 1

Constraints:
1 <= n <= 19

Link: https://leetcode.com/problems/unique-binary-search-trees/ */

class Solution {
    
    private int[] dp = new int[20];
    
    public int numTrees(int n) {
        if(n <= 1) return 1;
        if (dp[n] > 0) return dp[n];
        
        for(int i = 1; i <= n; i++) {
            dp[n] += numTrees(n - i) * numTrees(i - 1);
        }
        
        return dp[n];
    }
}