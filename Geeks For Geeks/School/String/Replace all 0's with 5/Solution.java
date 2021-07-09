/* Given a number N. The task is to complete the function convertFive() which replace all zeros in the number with 5 and returns the number.

Input:
The first line of input contains an integer T, denoting the number of testcases. Then T testcases follow. Each testcase contains a single integer N denoting the number.
Output:
The function will return integer where all zero's are converted to 5.
User Task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function convertFive().
Constraints:
1 <= T <= 10^3
1 <= N <= 10^4

Example:
Input
2
1004
121
Output
1554
121

Explanation:
Testcase 1:  At index 1 and 2 there is 0 so we replace it with 5.
Testcase 2: There is no ,0 so output will remain same.
    
Link: https://practice.geeksforgeeks.org/problems/replace-all-0-with-5-in-an-input-integer/1/?company[]=Amazon&company[]=Amazon&problemStatus=unsolved&difficulty[]=-2&page=1&query=company[]AmazonproblemStatusunsolveddifficulty[]-2page1company[]Amazon# */

// { Driver Code Starts
import java.util.*;
class Replace{
public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	int t=sc.nextInt();
	while(t-->0){
		int n=sc.nextInt();
		Solution g=new Solution();
		g.convertFive(n);
	}
}
}// } Driver Code Ends



/*Complete the function below*/
class Solution{
	public static void convertFive(int n){
	    StringBuilder sb = new StringBuilder(String.valueOf(n));
	    StringBuilder result = new StringBuilder();
	    for(int i=0; i<sb.length(); i++){
	        if(sb.charAt(i)=='0'){
	            result.append('5');
	        }else{
	            result.append(sb.charAt(i));
	        }
	    }
	    System.out.println(result);
}
}