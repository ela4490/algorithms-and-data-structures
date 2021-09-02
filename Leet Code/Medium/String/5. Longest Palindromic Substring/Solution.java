/* Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Example 3:
Input: s = "a"
Output: "a"

Example 4:
Input: s = "ac"
Output: "a"

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.
    
Link: https://leetcode.com/problems/longest-palindromic-substring/ */

class Solution {
    
    private String LPS = "";
    
    public String longestPalindrome(String s) {
        if(s.length()<=1) {
            return s;
        }
        
        for(int i = 1; i < s.length(); i++) {
            
            //Consider odd length
            int low = i;
            int high = i;
            
            LPS = findLPS(low, high, s);
            
            //Consider even length
            low = i - 1;
            high = i;
            
            LPS = findLPS(low, high, s);
            
        }
        
        return LPS;
    }
    private String findLPS(int low, int high, String s) {
        
        while(s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
                
            if(low == -1 || high == s.length()) {
                break;
            }
        }                
            
        String palindrome = s.substring(low + 1, high);
                
        if(palindrome.length() > LPS.length()) {
            LPS = palindrome;
        }
        
        return LPS;
    }
}