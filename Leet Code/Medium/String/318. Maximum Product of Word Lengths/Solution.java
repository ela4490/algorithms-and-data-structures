/* Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. If no such two words exist, return 0.

Example 1:
Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".

Example 2:
Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".

Example 3:
Input: words = ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.

Constraints:
2 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i] consists only of lowercase English letters.
    
Link: https://leetcode.com/problems/maximum-product-of-word-lengths/ */

class Solution {
    public int maxProduct(String[] words) {
        int[] state = new int[words.length];
        
        for(int i = 0; i < words.length; i++) {
            state[i] = getState(words[i]);
        }
        
        int max = 0;
        
        for(int i = 0; i < words.length; i++) {
            
            for(int j = i + 1; j < words.length; j++) {
                
                if((state[i] & state[j]) == 0) {
                    int temp = words[i].length() * words[j].length();
                    if(max < temp) {
                        max = temp;
                    }
                }
            }
        }
        
        return max;
    }
    private int getState(String s) {
        int state = 0;
        
        for(char c : s.toCharArray()) {
            int index = c - 'a';
            state = state | 1 << index;
        }
        
        return state;
    }
}