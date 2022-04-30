/* Given a string s, partition s such that every substring of the partition is a palindrome. Return the minimum cuts needed for a palindrome partitioning of s.

Example 1:
Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

Example 2:
Input: s = "a"
Output: 0

Example 3:
Input: s = "ab"
Output: 1

Constraints:
1 <= s.length <= 2000
s consists of lowercase English letters only.

Link: https://leetcode.com/problems/palindrome-partitioning-ii/ */

class Solution {
    public int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for(int g = 0; g < s.length(); g++) {
            for(int i = 0, j = g; j < dp.length; i++, j++) {
                
                if(g == 0) {
                    dp[i][j] = true;
                } else if(g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        
        int[] storage = new int[s.length()];
        storage[0] = 0;
        
        for(int j = 1; j < storage.length; j++) {
            if(dp[0][j]) {
                storage[j] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                
                for(int i = j; i >= 1; i--) {
                    if(dp[i][j]) {
                        if(storage[i - 1] < min) {
                            min = storage[i - 1];
                        }
                    }
                }
                
                storage[j] = min + 1;
            }
        }
        
        return storage[storage.length - 1];
    }
}