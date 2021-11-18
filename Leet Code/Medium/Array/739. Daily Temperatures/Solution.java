/* Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]

Constraints:
1 <= temperatures.length <= 10^5
30 <= temperatures[i] <= 100

Link: https://leetcode.com/problems/daily-temperatures/ */

class Solution {
	public int[] dailyTemperatures(int[] temperatures) {
		int len = temperatures.length;
		int[] ans = new int[len];

		Stack<Integer> st = new Stack<>();

		for(int i = 0; i < len; i++) {

			while(!st.empty() && temperatures[st.peek()] < temperatures[i]) {
				// found an increasing value for st.peek() index
				ans[st.peek()] = i - st.peek();
				st.pop();
			}

			st.push(i);

		}
		return ans;
	}
}