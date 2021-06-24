/* You're given a number N. If N is divisible by 5 or 11 but not both then print "ONE"(without quotes). If N is divisible by both 5 and 11 then print "BOTH"(without quotes). If N is not divisible by 5 or 11 then print "NONE"(without quotes).

Input:
First-line will contain the number N.

Output:
Print the answer in a newline.

Constraints
1≤N≤10^3

Sample Input 1:
50
Sample Output 1:
ONE

Sample Input 2:
110
Sample Output 2:
BOTH

Sample Input 2:
16
Sample Output 2:
NONE

EXPLANATION:
In the first example, 50 is divisible by 5, but not 11.
In the second example, 110 is divisible by both 5 and 11.
In the third example, 16 is not divisible by 5 or 11.


Link: https://www.codechef.com/CCSTART2/problems/ISBOTH */

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
		    if(N%5==0 && N%11==0){
		        System.out.println("BOTH");
		    }else if(N%5==0 || N%11==0){
		        System.out.println("ONE");
		    }else{
		        System.out.println("NONE");
		    }
		}
	}
}