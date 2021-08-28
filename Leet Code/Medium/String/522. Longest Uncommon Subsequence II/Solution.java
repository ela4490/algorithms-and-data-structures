/* Given an array of strings strs, return the length of the longest uncommon subsequence between them. If the longest uncommon subsequence does not exist, return -1. An uncommon subsequence between an array of strings is a string that is a subsequence of one string but not the others. A subsequence of a string s is a string that can be obtained after deleting any number of characters from s. For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters in "aebdc" to get "abc". Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).

Example 1:
Input: strs = ["aba","cdc","eae"]
Output: 3

Example 2:
Input: strs = ["aaa","aaa","aa"]
Output: -1

Constraints:
1 <= strs.length <= 50
1 <= strs[i].length <= 10
strs[i] consists of lowercase English letters.
    
Link: https://leetcode.com/problems/longest-uncommon-subsequence-ii/ */

class Solution {
    public int findLUSlength(String[] strs) {
        int maxLength = -1;
        for(int i=0; i<strs.length; i++) {
            boolean flag = false;
            int currentLength = strs[i].length();
            for(int j=0; j<strs.length; j++) {
                if(i!=j && isSubsequence(strs[i], strs[j])) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
    private boolean isSubsequence(String a, String b) {
        if(a.equals(b)) return true;
        int i = 0;
        int j = 0;
        while(i<a.length() && j<b.length()) {
            if(a.charAt(i)==b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i==a.length();
    }
}