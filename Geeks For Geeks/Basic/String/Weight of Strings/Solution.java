/* You are given two strings S1 and S2. You need to find weights of both strings and compare them. The weight of a string can be obtained by adding individual weights of the characters that make the string. The weight of individual characters are the position on which they occur in the english alphabets table; for eg, a has weight 1, z has weight 26.

Input:
The first line of the input contains a single integer T, denoting the number of test cases. Then T test cases follow. Each testcase has 2 lines
The first string S1
The second string S2
Output:
Print 1 if the weight of the first string is greater. Print 2 if the weight of the second string is greater. Print equal if the the weights are equal.

Constraints:
1<=T<=100
1<=|S1|<=1000
1<=|S2|<=1000

Example:
Input:
4
batman
superman
kira
l
goku
broly
manbat
batman
Output:
2
1
2
equal

Note: The strings contains only lowercase characters.
    
Link: https://practice.geeksforgeeks.org/problems/weight-of-strings/0/?problemStatus=unsolved&problemType=full&difficulty[]=-1&page=1&query=problemStatusunsolvedproblemTypefulldifficulty[]-1page1# */

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
		        String S1 = s.next();
		        String S2 = s.next();
		        int sum1 = 0;
		        int sum2 = 0;
		        for(int j=0; j<S1.length(); j++){
		            sum1 += S1.charAt(j) - 96;
		        }
		        for(int j=0; j<S2.length(); j++){
		            sum2 += S2.charAt(j) - 96;
		        }
		        if(sum1>sum2){
		            System.out.println("1");
		        }else if(sum1<sum2){
		            System.out.println("2");
		        }else{
		            System.out.println("equal");
		        }
		    }
		}
	}
}