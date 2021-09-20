/* Given a string s, return true if s is a good string, or false otherwise. A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency).

Example 1:
Input: s = "abacbc"
Output: true
Explanation: The characters that appear in s are 'a', 'b', and 'c'. All characters occur 2 times in s.

Example 2:
Input: s = "aaabb"
Output: false
Explanation: The characters that appear in s are 'a' and 'b'.
'a' occurs 3 times while 'b' occurs 2 times, which is not the same number of times.

Constraints:
1 <= s.length <= 1000
s consists of lowercase English letters.
    
Link: https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/ */

class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] count = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        int first = count[s.charAt(0) - 'a'];
        
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 0 && first != count[i]) return false;
        }
        
        return true;
    }
}