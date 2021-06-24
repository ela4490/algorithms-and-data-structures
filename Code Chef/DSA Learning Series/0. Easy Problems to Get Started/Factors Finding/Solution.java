/* You are given a number N and find all the distinct factors of N.

Input:
First-line will contain the number N.

Output:
In the first line print number of distinct factors of N.
In the second line print all distinct factors in ascending order separated by space.

Constraints
1≤N≤10^6

Sample Input 1:
4
Sample Output 1:
3
1 2 4

Sample Input 2:
6
Sample Output 2:
4
1 2 3 6

EXPLANATION:
In the first example, all factors of 4 are 1, 2, 4.
In the second example, all factors of 6 are 1, 2, 3, 6.

Link: https://www.codechef.com/CCSTART2/problems/DIFACTRS */

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
		    int N = s.nextInt();
		    int count = 0;
		    for(int i=1; i<=N; i++){
		        if(N%i==0){
		            count++;
		        }
		    }
		    System.out.println(count);
		    for(int i=1; i<=N; i++){
		        if(N%i==0){
		            System.out.println(i);
		        }
		    }
		}
	}
}