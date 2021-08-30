/* There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right. After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right. When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces. For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino. You are given a string dominoes representing the initial state where:
dominoes[i] = 'L', if the ith domino has been pushed to the left,
dominoes[i] = 'R', if the ith domino has been pushed to the right, and
dominoes[i] = '.', if the ith domino has not been pushed.
Return a string representing the final state.

Example 1:
Input: dominoes = "RR.L"
Output: "RR.L"
Explanation: The first domino expends no additional force on the second domino.

Example 2:
Input: dominoes = ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."

Constraints:
n == dominoes.length
1 <= n <= 10^5
dominoes[i] is either 'L', 'R', or '.'.
    
Link: https://leetcode.com/problems/push-dominoes/ */

class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        
        int[] left = new int[n];
        int leftIndex = -1;
        
        for(int i=n-1; i>=0; i--) {
            char c = dominoes.charAt(i);
            if(c=='L') {
                leftIndex = i;
            } else if(c=='R') {
                leftIndex = -1;
            }
            left[i] = leftIndex;
        }
        
        int[] right = new int[n];
        int rightIndex = -1;
        
        for(int i=0; i<n; i++) {
            char c = dominoes.charAt(i);
            if(c=='R') {
                rightIndex = i;
            } else if(c=='L') {
                rightIndex = -1;
            }
            right[i] = rightIndex;
        }
        
        char[] result = new char[n];
        for(int i=0; i<n; i++) {
            
            if(dominoes.charAt(i)=='.') {
                int nearestLeft = left[i];
                int nearestRight = right[i];
                int leftDiff = (nearestLeft==-1) ? Integer.MAX_VALUE : Math.abs(nearestLeft-i);
                int rightDiff = (nearestRight==-1) ? Integer.MAX_VALUE : Math.abs(nearestRight-i);
                
                if(leftDiff==rightDiff) {
                    result[i] = '.';
                }else if(leftDiff<rightDiff) {
                    result[i] = 'L';
                } else if(leftDiff>rightDiff) {
                    result[i] = 'R';
                }
                
            } else {
                result[i] = dominoes.charAt(i);
            }
            
        }
        
        return new String(result);
    }
}