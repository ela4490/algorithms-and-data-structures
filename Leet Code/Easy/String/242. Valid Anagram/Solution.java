/* Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 10^4
s and t consist of lowercase English letters.

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

Link: https://leetcode.com/problems/valid-anagram/ */

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0; i<t.length(); i++){
            freq[t.charAt(i)-'a']--;
        }
        for(int i=0; i<freq.length; i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
    }
}