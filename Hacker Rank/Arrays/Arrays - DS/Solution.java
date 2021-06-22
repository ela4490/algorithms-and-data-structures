/* Link: https://www.hackerrank.com/challenges/arrays-ds/problem */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ReverseArray
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			a[i] = s.nextInt();
		}
		for(int j = n ; j > 0 ; j--)
		{
			System.out.print(a[j-1]);
            System.out.print(" ");
		}
    }
}
