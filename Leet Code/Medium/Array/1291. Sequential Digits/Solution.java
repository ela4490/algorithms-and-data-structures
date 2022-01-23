/* An integer has sequential digits if and only if each digit in the number is one more than the previous digit. Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

Example 1:
Input: low = 100, high = 300
Output: [123,234]

Example 2:
Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]

Constraints:
10 <= low <= high <= 10^9
    
Link: https://leetcode.com/problems/sequential-digits/ */

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        int[] possibleNumbers = {12, 23, 34, 45, 56, 67, 78, 89,
                                123, 234, 345, 456, 567, 678, 789,
                                1234, 2345, 3456, 4567, 5678, 6789,
                                12345, 23456, 34567, 45678, 56789,
                                123456, 234567, 345678, 456789,
                                1234567, 2345678, 3456789,
                                12345678, 23456789,
                                123456789};
        
        for(int i = 0; i < possibleNumbers.length; i++) {
            if(low <= possibleNumbers[i] && high >= possibleNumbers[i]) {
                result.add(possibleNumbers[i]);
            }
        }
        
        return result;
    }
}