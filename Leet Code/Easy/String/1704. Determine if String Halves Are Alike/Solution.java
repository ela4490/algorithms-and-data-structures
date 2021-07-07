/* You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half. Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters. Return true if a and b are alike. Otherwise, return false.

Example 1:
Input: s = "book"
Output: true
Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.

Example 2:
Input: s = "textbook"
Output: false
Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
Notice that the vowel o is counted twice.

Example 3:
Input: s = "MerryChristmas"
Output: false

Example 4:
Input: s = "AbCdEfGh"
Output: true

Constraints:
2 <= s.length <= 1000
s.length is even.
s consists of uppercase and lowercase letters.
    
Link: https://leetcode.com/problems/determine-if-string-halves-are-alike/ */

class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        String part1 = s.substring(0, n/2).toLowerCase();
        String part2 = s.substring(n/2, n).toLowerCase();
        int count1=0, count2=0;
        for(int i=0; i<part1.length(); i++){
            if(part1.charAt(i)=='a' || part1.charAt(i)=='e' || part1.charAt(i)=='i' || part1.charAt(i)=='o' || part1.charAt(i)=='u'){
                count1++;
            }
        }
        for(int i=0; i<part2.length(); i++){
            if(part2.charAt(i)=='a' || part2.charAt(i)=='e' || part2.charAt(i)=='i' || part2.charAt(i)=='o' || part2.charAt(i)=='u'){
                count2++;
            }
        }
        return (count1==count2)?true:false;
    }
}