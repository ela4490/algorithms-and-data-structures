/* Given an NxM 2D matrix, rearrange such that 
Each diagonal in the lower left triangle of the rectangular grid is sorted in ascending order. 
Each diagonal in the upper right triangle of the rectangular grid is sorted in descending order. 
The major diagonal in the grid starting from the top-left corner is not rearranged. 

Example 1:
Input:
N = 4, M = 5 
matrix = {{3 6 3 8 2},
          {4 1 9 5 9},
          {5 7 2 4 8},
          {8 3 1 7 6}}
Output:
3 9 8 9 2
1 1 6 5 8
3 4 2 6 3
8 5 7 7 4

Your Task:
You don't need to read input or print anything. Your task is to complete the function diagonalSort() which takes the matrix, n and m as input parameter and rearranges the elements of the matrix.
Expected Time Complexity: O(NxM)
Expected Auxiliary Space: O(N+M)

Constraints:
1 <= N,M <= 10^4 , 1<=N*M<=10^5
1 <= matrix[i] <= 10^3
    
Link: https://practice.geeksforgeeks.org/problems/diagonal-morning-assembly0028/1# */

// { Driver Code Starts
//Initial Template for Java

import java.util.*; 
import java.io.*;
import java.lang.*;

class GFG
{
	public static void main(String[] args) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] matrix = new int[n][m];
            
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    matrix[i][j] = sc.nextInt();
            
            Solution ob = new Solution();
            ob.diagonalSort(matrix,n,m);
            printMatrix (matrix);
        }
	} 
	
	static void printMatrix(int arr[][]) 
	{ 
		for (int i = 0; i < arr.length; i++) { 
			for (int j = 0; j < arr[0].length; j++) 
				System.out.print(arr[i][j] + " "); 
			System.out.println(""); 
		} 
	} 
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    void diagonalSort(int matrix[][], int n, int m)
    {
        //col=0
        for(int row=1; row<n; row++){
            sort(matrix, row, 0, n, m);
        }
        //row=0
        for(int col=1; col<m; col++){
            reverse(matrix, 0, col, n, m);
        }
    }
    void sort(int[][] mat, int row, int col, int m, int n){
        List<Integer> values = new ArrayList<>();
        int r = row,c = col;
        while(r<m && c<n){
            values.add(mat[r][c]);
            r++;
            c++;
        }
        
        Collections.sort(values);
        
        r = row;
        c = col;
        int ind = 0;
        while(r<m && c<n){
            mat[r][c] = values.get(ind++);
            r++;
            c++;
        }
    }
    void reverse(int[][] mat, int row, int col, int m, int n){
        List<Integer> values = new ArrayList<>();
        int r = row,c = col;
        while(r<m && c<n){
            values.add(mat[r][c]);
            r++;
            c++;
        }
        
        Collections.sort(values);
        Collections.reverse(values);
        
        r = row;
        c = col;
        int ind = 0;
        while(r<m && c<n){
            mat[r][c]=values.get(ind++);
            r++;
            c++;
        }
    }
}
