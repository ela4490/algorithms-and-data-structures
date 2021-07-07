/* Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:
Input: s = "God Ding"
Output: "doG gniD"

Constraints:
1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
    
Link: https://leetcode.com/problems/reverse-words-in-a-string-iii/ */

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.split(" ");
        for(int i=0; i<str.length; i++){
            for(int j=str[i].length()-1; j>=0; j--){
                sb.append(str[i].charAt(j));
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}