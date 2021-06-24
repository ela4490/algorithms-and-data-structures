/* You are given a number N and find the sum of the first N odd and even numbers in a line separated by space. All even and odd numbers should be greater than 0.

Input:
First-line will contain the number N.

Output:
Print the sum of the first N odd and even numbers in a line separated by space.

Constraints
1≤N≤10^6

Sample Input 1:
4
Sample Output 1:
16 20

Sample Input 2:
1
Sample Output 2:
1 2

EXPLANATION:
In the first example, (1 + 3 + 5 + 7) = 16 and (2 + 4 + 6 + 8) = 20.
In the second example, only one odd that is 1 and only one even that is 2.

Link: https://www.codechef.com/CCSTART2/problems/SUMEVOD */

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
		    long even = 0;
		    long odd = 0;
		    int i = 0;
		    int n = 0;
		    while(n<=N){
		        even = even + i;
		        i = i + 2;
		        n++;
		    }
		    n = 0;
		    i = 1;
		    while(n<N){
		        odd += i;
		        i = i + 2;
		        n++;
		    }
		    System.out.println(odd + " " + even);
		}
	}
}