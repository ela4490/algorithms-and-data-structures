/* You're given the length of three sides a, b, and c respectively. Now check if these three sides can form a triangle or not. Print "YES"(without quotes) if it can form a valid triangle with an area greater than 0, otherwise print "NO" (without quotes).

Input:
First-line will contain three numbers a, b, and c separated by space.

Output:
Print "YES"(without quotes) if these sides can form a valid triangle, otherwise print "NO" (without quotes).

Constraints
1≤a,b,c≤10^6

Sample Input 1:
2 4 3
Sample Output 1:
YES

Sample Input 2:
1 1 4
Sample Output 2:
NO

EXPLANATION:
In the first example, (2, 4, 3) can form a triangle with an area greater than 0.
In the second example, (1, 1, 4) will never form a valid triangle.


Link: https://www.codechef.com/CCSTART2/problems/TRIVALCH */

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
		    int a = s.nextInt();
		    int b = s.nextInt();
		    int c = s.nextInt();
		    if(c>(a+b) || b>(a+c) || a>(b+c)){
		        System.out.println("NO");
		    }else{
		        System.out.println("YES");
		    }
		}
	}
}