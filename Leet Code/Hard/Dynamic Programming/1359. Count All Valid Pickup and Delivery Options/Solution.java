/* Given n orders, each order consist in pickup and delivery services. Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i). Since the answer may be too large, return it modulo 10^9 + 7.

Example 1:
Input: n = 1
Output: 1
Explanation: Unique order (P1, D1), Delivery 1 always is after of Pickup 1.

Example 2:
Input: n = 2
Output: 6
Explanation: All possible orders: 
(P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1).
This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2.

Example 3:
Input: n = 3
Output: 90

Constraints:
1 <= n <= 500

Link: https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/ */

class Solution {
    public int countOrders(int n) {
        long[] dp = new long[501];
        int mod = (int) Math.pow(10,9) + 7;
        
        dp[1] = 1L;
        dp[2] = 6L;
        
        for (int i = 3;i <= n; i++) {
            int odddNo = 2 * i -1;
            int permutations = odddNo * (odddNo + 1) / 2;
            dp[i] = (dp[i-1] * (permutations)) % mod;
        }
        
        return (int) dp[n];
    }
}