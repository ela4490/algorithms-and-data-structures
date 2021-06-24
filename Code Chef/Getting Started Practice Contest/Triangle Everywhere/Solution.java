/* You're given the length of three sides a, b, and c respectively. Now If these three sides can form an Equilateral Triangle then print 1, if these three sides can form an Isosceles Triangle then print 2, if these three sides can form a Scalene Triangle then print 3, otherwise print −1.

Input:
First-line will contain three numbers a, b, and c separated by space.

Output:
Print the answer in a new line.

Constraints
1≤a,b,c≤10^3

Sample Input 1:
2 4 3
Sample Output 1:
3

Sample Input 2:
4 4 4
Sample Output 2:
1

Sample Input 3:
4 4 9
Sample Output 2:
-1

EXPLANATION:
In the first example, (2, 4, 3) will form a Scalene Triangle.
In the second example, (4, 4, 4) will form an Equilateral Triangle.
In the third example, (4, 4, 9) will not form a triangle.

Link: https://www.codechef.com/CCSTART2/problems/EXTRICHK */

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
		    if(a==b && b==c && c==a){
		        System.out.println("1");
		    }else if((a==b || b==c || c==a) && (a+b>c) && (b+c>a) && (a+b>c)){
		        System.out.println("2");
		    }else if((a+b>c) && (b+c>a) && (a+b>c)){
		        System.out.println("3");
		    }else{
		        System.out.println("-1");
		    }
		}
	}
}