/* Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s. A palindrome string is a string that reads the same backward as forward.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:
Input: s = "a"
Output: [["a"]]

Constraints:
1 <= s.length <= 16
s contains only lowercase English letters.

Link: https://leetcode.com/problems/palindrome-partitioning/ */

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        
        if(s == null || s.length() == 0) {
            return result;
        }
        
        helper(result, new ArrayList<>(), s);
        return result;
    }
    
    private void helper(List<List<String>> result, List<String> current, String s) {
        if(s.length() == 0) {
            result.add(new ArrayList<>(current));
        }
        
        for(int i = 0; i < s.length(); i++) {
            String first = s.substring(0, i + 1);
            
            if(isPalindrome(first)) {
                current.add(first);
                String second = s.substring(i + 1, s.length());
                helper(result, current, second);
                current.remove(current.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        return s.equals(reverse);
    }
}