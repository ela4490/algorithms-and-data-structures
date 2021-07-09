/* Geek created a random series and given a name geek-onacci series. Given four integers A, B, C, N. A, B, C represents the first three numbers of geek-onacci series. Find the Nth number of the series. The nth number of geek-onacci series is a sum of the last three numbers (summation of N-1th, N-2th, and N-3th geek-onacci numbers)

Input:
1. The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
2. The first line of each test case contains four space-separated integers A, B, C, and N.
Output: For each test case, print Nth geek-onacci number

Constraints:
1. 1 <= T <= 3
2. 1 <= A, B, C <= 100
3. 4 <= N <= 10

Example:
Input:
3
1 3 2 4
1 3 2 5
1 3 2 6
Output:
6
11
19
    
Link: https://practice.geeksforgeeks.org/problems/geek-onacci-number/0/?problemStatus=unsolved&problemType=full&difficulty[]=0&page=1&query=problemStatusunsolvedproblemTypefulldifficulty[]0page1# */

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    Scanner s = new Scanner(System.in);
	    while(s.hasNext()){
	        int T = s.nextInt();
	        for(int i=0; i<T; i++){
	            int A = s.nextInt();
	            int B = s.nextInt();
	            int C = s.nextInt();
	            int N = s.nextInt();
	            int temp = 0;
	            for(int j=4; j<=N; j++){
	                temp = A+B+C;
	                if(j==N){
	                    System.out.println(temp);
	                }
	                A = B;
	                B = C;
	                C = temp;
	            }
	        }
	    }
	}
}