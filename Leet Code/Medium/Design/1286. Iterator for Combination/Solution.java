/* Design the CombinationIterator class:
CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
next() Returns the next combination of length combinationLength in lexicographical order.
hasNext() Returns true if and only if there exists a next combination.

Example 1:
Input
["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[["abc", 2], [], [], [], [], [], []]
Output
[null, "ab", true, "ac", true, "bc", false]

Explanation
CombinationIterator itr = new CombinationIterator("abc", 2);
itr.next();    // return "ab"
itr.hasNext(); // return True
itr.next();    // return "ac"
itr.hasNext(); // return True
itr.next();    // return "bc"
itr.hasNext(); // return False

Constraints:
1 <= combinationLength <= characters.length <= 15
All the characters of characters are unique.
At most 104 calls will be made to next and hasNext.
It is guaranteed that all calls of the function next are valid.
    
Link: https://leetcode.com/problems/iterator-for-combination/ */

class CombinationIterator {

    PriorityQueue<String> pq = new PriorityQueue<String>();

    public CombinationIterator(String characters, int combinationLength) {
        generateCombinations(characters, combinationLength, 0, new StringBuilder());
    }

    private void generateCombinations(String input, int len, int start, StringBuilder currStr) {
        
        if(len == 0){
            pq.add(currStr.toString());
            return ;
        }

        for(int i = start; i <= input.length() - len; i++) {
            currStr.append(input.charAt(i));
            generateCombinations(input, len - 1, i + 1, currStr);
            currStr.setLength(currStr.length() - 1);
        }
    }

    public String next() {
        
        if(hasNext()) {
            return pq.poll();
        } else {
            return null;
        }
        
    }

    public boolean hasNext() {
        return (pq.size() > 0);
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */