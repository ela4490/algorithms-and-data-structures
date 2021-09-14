/* Given a string s, reverse the string according to the following rules:
All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

Example 1:
Input: s = "ab-cd"
Output: "dc-ba"

Example 2:
Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Example 3:
Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"

Constraints:
1 <= s.length <= 100
s consists of characters with ASCII values in the range [33, 122].
s does not contain '\"' or '\\'.
    
Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3974/ */

class Solution {
    public String reverseOnlyLetters(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] letters = s.toCharArray();
        
        while(i <= j) {
            
            if(!Character.isLetter(letters[i])) {
                i++;
                continue;
            }
            
            if(!Character.isLetter(letters[j])) {
                j--;
                continue;
            }
            
            char ch = letters[i];
            letters[i] = letters[j];
            letters[j] = ch;
            i++;
            j--;
            
        }
        
        return new String(letters);
    }
}