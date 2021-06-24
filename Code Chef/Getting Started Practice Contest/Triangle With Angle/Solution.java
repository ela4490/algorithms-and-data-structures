/* You're given the three angles a, b, and c respectively. Now check if these three angles can form a valid triangle with an area greater than 0 or not. Print "YES"(without quotes) if it can form a valid triangle with an area greater than 0, otherwise print "NO" (without quotes).

Input:
First-line will contain three numbers a, b, and c separated by space.

Output:
Print "YES"(without quotes) if these sides can form a valid triangle, otherwise print "NO" (without quotes).

Constraints
0≤a,b,c≤180

Sample Input 1:
20 40 120
Sample Output 1:
YES

Sample Input 2:
100 18 42
Sample Output 2:
NO

EXPLANATION:
In the first example, angles set (20, 40, 120) can form a triangle with an area greater than 0.
In the second example, angles set (100, 18, 42) will never form a valid triangle.

Link: https://www.codechef.com/CCSTART2/problems/ANGTRICH */

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
		    if(a>0 && b>0 && c>0 && (a+b+c==180) && ((a+b>c) || (b+c>a) || (c+a>b))){
		        System.out.println("YES");
		    }else{
		        System.out.println("NO");
		    }
		}
	}
}