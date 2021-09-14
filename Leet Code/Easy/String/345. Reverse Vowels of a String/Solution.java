/* Given a string s, reverse only all the vowels in the string and return it. The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.

Example 1:
Input: s = "hello"
Output: "holle"

Example 2:
Input: s = "leetcode"
Output: "leotcede"

Constraints:
1 <= s.length <= 3 * 10^5
s consist of printable ASCII characters.
    
Link: https://leetcode.com/problems/reverse-vowels-of-a-string/ */

class Solution {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] letters = s.toCharArray();
        
        while(i <= j) {
            
            if(!isVowel(letters[i])) {
                i++;
                continue;
            }
            
            if(!isVowel(letters[j])) {
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
    
    private boolean isVowel(char ch) {
        char c = Character.toLowerCase(ch);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
