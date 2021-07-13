/* Given a 2D board of letters and a word. Check if the word exists in the board. The word can be constructed from letters of adjacent cells only. ie - horizontal or vertical neighbors. The same letter cell can not be used more than once.

Example 1:
Input: board = {{a,g,b,c},{q,e,e,l},{g,b,k,s}},
word = "geeks"
Output: 1
Explanation: The board is-
a g b c
q e e l
g b k s
The letters which are used to make the "geeks" are colored.

Example 2:
Input: board = {{a,b,c,e},{s,f,c,s},{a,d,e,e}},
word = "sabfs"
Output: 0
Explanation: The board is-
a b c e
s f c s
a d e e
Same letter can not be used twice hence ans is 0

Your Task:
You don't need to read or print anything. Your task is to complete the function isWordExist() which takes board and word as input parameter and returns boolean value true if word can be found otherwise returns false.

Expected Time Complexity: O(N * M * 4L) where N = No. of rows in board, M = No. of columns in board, L = Length of word
Expected Space Compelxity: O(L), L is length of word.

Constraints:
1 ≤ N, M ≤ 100
1 ≤ L ≤ N*M
    
Link: https://practice.geeksforgeeks.org/problems/word-search/1/?category[]=Backtracking&category[]=Backtracking&page=1&query=category[]Backtrackingpage1category[]Backtracking# */

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}// } Driver Code Ends


class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j]==word.charAt(0) && dfs(board, i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j, int count, String word){
        if(count==word.length()){
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[i].length || board[i][j]!=word.charAt(count)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(board, i+1, j, count+1, word) || dfs(board, i-1, j, count+1, word) 
                    || dfs(board, i, j+1, count+1, word) || dfs(board, i, j-1, count+1, word);
        board[i][j] = temp;
        return found;
    }
}