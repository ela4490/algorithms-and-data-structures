/* Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Example 4:
Input: s = ""
Output: 0

Constraints:
0 <= s.length <= 5 * 10^4
s consists of English letters, digits, symbols and spaces.
    
Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/ */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int len = 0;
        for(int end=0; end<s.length(); end++) {
            char c = s.charAt(end);
            if(map.containsKey(c)) {
                if(start<=map.get(c)) {
                    start = map.get(c)+1;
                }
            }
            len = Math.max(len, end-start+1);
            map.put(c, end);
        }
        return len;
    }
}