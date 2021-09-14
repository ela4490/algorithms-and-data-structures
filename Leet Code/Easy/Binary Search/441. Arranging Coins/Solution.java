/* You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete. Given the integer n, return the number of complete rows of the staircase you will build.

Example 1:
Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.

Example 2:
Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.

Constraints:
1 <= n <= 2^31 - 1
    
Link: https://leetcode.com/problems/arranging-coins/ */

// Time Complexity : O(N)
class Solution {
    public int arrangeCoins(int n) {
        int count = 1;
        
        while(n > 0) {
            n = n - count;
            
            if(n < 0) {
                break;
            }
            
            count++;
        }
        
        return count - 1;
    }
}

// Using Binary Search
// Time Complexity : O(logN)
class Solution {
    public int arrangeCoins(int n) {
        long start = 1;
        long end = n;
        
        while(start <= end) {
            long mid = start + (end - start)/2;
            long sum = mid * (mid + 1)/2;
            
            if(sum == n) {
                return (int)mid;
            } else if(n < sum) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            
        }
        
        return (int)end;
    }
}