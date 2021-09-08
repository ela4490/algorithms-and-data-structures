/* Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:
Input: s = "bcabc"
Output: "abc"

Example 2:
Input: s = "cbacdcbc"
Output: "acdb"

Constraints:
1 <= s.length <= 10^4
s consists of lowercase English letters.

Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
    
Link: https://leetcode.com/problems/remove-duplicate-letters/ */

class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] freq = new int[26];
        boolean[] exist = new boolean[26];
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']--;
            
            if(exist[ch - 'a']) continue;
            
            while(!stack.isEmpty() && stack.peek() > ch && freq[stack.peek() - 'a'] > 0) {
                exist[stack.pop() - 'a'] = false;
            }
            
            stack.push(ch);
            exist[ch - 'a'] = true;
        }
        
        char[] result = new char[stack.size()];
        int i = result.length - 1;
        
        while(i >= 0) {
            result[i--] = stack.pop();
        }
        
        return new String(result);
    }
}