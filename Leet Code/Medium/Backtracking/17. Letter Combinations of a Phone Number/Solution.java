/* Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order. A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]

Constraints:
0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].

Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/ */

class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        if(digits.length()==0){
            return result;
        }
        
        recursive(result, digits, "", 0, mapping);
        return result;
    }
    private void recursive(ArrayList<String> result, String digits, String current, int index, String[] mapping)
    {
        if(index==digits.length()){
            result.add(current);
            return;
        }
        String letters = mapping[digits.charAt(index)-'0'];
        
        for(int i=0; i<letters.length(); i++){
            recursive(result, digits, current+letters.charAt(i), index+1, mapping);
        }
    }
}