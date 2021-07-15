/* Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Constraints:
1 <= s.length <= 2 * 10^5
s consists only of printable ASCII characters.

Link: https://leetcode.com/problems/valid-palindrome/ */

class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]|\\s+","").toLowerCase();
        for(int i=0, j=str.length()-1; i<str.length() && j>=0; i++, j--){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
        }
        return true;
    }
}