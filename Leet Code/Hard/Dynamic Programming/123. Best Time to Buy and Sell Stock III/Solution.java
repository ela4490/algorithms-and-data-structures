/* You are given an array prices where prices[i] is the price of a given stock on the ith day. Find the maximum profit you can achieve. You may complete at most two transactions. Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:
Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.

Example 3:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

Example 4:
Input: prices = [1]
Output: 0

Constraints:
1 <= prices.length <= 10^5
0 <= prices[i] <= 10^5

Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/ */

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int lsf = prices[0];
        int maxl = 0;
        int[] dpl = new int[n];
        
        for(int i = 1; i < n; i++) {
            
            if(prices[i] < lsf) lsf = prices[i];
            maxl = prices[i] - lsf;
            
            if(dpl[i - 1] < maxl) {
                dpl[i] = maxl;
            } else {
                dpl[i] = dpl[i - 1];
            }
            
        }
        
        int msf = prices[n - 1];
        int maxr = 0;
        int[] dpr = new int[n];
        
        for(int i = n - 2; i >= 0; i--) {
            
            if(prices[i] > msf) msf = prices[i];
            maxr = msf - prices[i];
            
            if(dpr[ i + 1] < maxr) {
                dpr[i] = maxr;
            } else{
                dpr[i] = dpr[i + 1];
            }
            
        }
        
        int total_profit = 0;
            
        for(int i = 0; i < n; i++) {
            total_profit = Math.max(total_profit, dpr[i] + dpl[i]);
        }
        
        return total_profit;
    }
}