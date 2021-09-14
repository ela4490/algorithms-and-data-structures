/* Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible. You can use each character in text at most once. Return the maximum number of instances that can be formed.

Example 1:
Input: text = "nlaebolko"
Output: 1

Example 2:
Input: text = "loonbalxballpoon"
Output: 2

Example 3:
Input: text = "leetcode"
Output: 0

Constraints:
1 <= text.length <= 10^4
text consists of lower case English letters only.
    
Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3973/ */

class Solution {
    public int maxNumberOfBalloons(String text) {
        int count = 0;
        int[] freq = new int[26];
        
        for(char c : text.toCharArray()) {
            freq[c - 'a']++;
        }
        
        char[] balloon = {'b', 'a', 'l', 'o', 'n'};
        int min = Integer.MAX_VALUE;
        
        for(char c : balloon) {
            
            if(c == 'l' || c == 'o') {
                freq[c - 'a'] = freq[c - 'a'] / 2;
            }
            
            min = Math.min(min, freq[c - 'a']);
        }
        
        return min == Integer.MIN_VALUE ? 0 : min;
    }
}