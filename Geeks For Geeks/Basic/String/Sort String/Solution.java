/* Given a string of lowercase characters from ‘a’ – ‘z’. We need to write a program to print the characters of this string in sorted order.

Input:
The first line contains an integer T, denoting number of test cases. Then T test case follows. First line of each test case contains a string S each.
Output:
For each test case, print the string S in sorted order.

Constraints:
1<=T<=100
1<=|S|<=4*10^4
String S will contains lowercase character from 'a'-'z

Example:
Input:
2
bbccdefbbaa
geeksforgeeks
Output :
aabbbbccdef
eeeefggkkorss
    
Link: https://practice.geeksforgeeks.org/problems/sort-string/0/?problemStatus=unsolved&problemType=full&difficulty[]=-1&page=1&query=problemStatusunsolvedproblemTypefulldifficulty[]-1page1# */

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
		        String str = s.next();
		        char[] c = str.toCharArray();
		        Arrays.sort(c);
		        System.out.println(String.valueOf(c));
		    }
		}
	}
}