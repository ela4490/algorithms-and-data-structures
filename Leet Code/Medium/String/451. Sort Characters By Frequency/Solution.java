/* Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string. Return the sorted string. If there are multiple answers, return any of them.

Example 1:
Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:
Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:
Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

Constraints:
1 <= s.length <= 5 * 10^5
s consists of uppercase and lowercase English letters and digits.

Link: https://leetcode.com/problems/sort-characters-by-frequency/ */

class Solution {
    public String frequencySort(String s) {
        if(s == null) {
            return null;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        
        for(char c : s.toCharArray()) {
            
            if(!map.containsKey(c)) {
                map.put(c, 0);
            }
            
            map.put(c, map.get(c) + 1);
            max = Math.max(max, map.get(c));
        }
        
        List<Character>[] list = buildBucketArray(map, max);
        return buildOutputString(list);
    }
    
    private List<Character>[] buildBucketArray(Map<Character, Integer> map, int max) {
        List<Character>[] array = new List[max + 1];
        
        for(Character c : map.keySet()) {
            int count = map.get(c);
            
            if(array[count] == null) {
                array[count] = new ArrayList();
            }
            
            array[count].add(c);
        }
        
        return array;
    }
    
    private String buildOutputString(List<Character>[] list) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = list.length - 1; i > 0; i-- ) {
            List<Character> array = list[i];
			
            if (array != null) {
				
                for(Character c : array) {
					for(int j = 0; j < i; j++) {
						sb.append(c);
					}
				}   
			}  
        }
        
        return sb.toString();
    }
}