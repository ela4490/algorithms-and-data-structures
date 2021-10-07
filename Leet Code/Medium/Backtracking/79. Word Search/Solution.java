/* Given an m x n grid of characters board and a string word, return true if word exists in the grid. The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

Constraints:
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.

Follow up: Could you use search pruning to make your solution faster with a larger board?

Link: https://leetcode.com/problems/word-search/ */

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] cword = word.toCharArray();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                
                if(cword[0] == board[i][j]) {
                    boolean[][] visited = new boolean[m][n];
                    if(dfs(board, cword, visited, i, j, 0)) {
                        return true;
                    }
                }
                
            }
        }
        
        return false;
    }
    private boolean dfs(char[][] board, char[] cword, boolean[][] visited, int i, int j, int index) {
        if(index == cword.length) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] == true) return false;
        if(board[i][j] != cword[index]) return false;
        
        visited[i][j] = true;
        
        if(dfs(board, cword, visited, i + 1, j, index + 1) || dfs(board, cword, visited, i - 1, j, index + 1) || dfs(board, cword, visited, i, j + 1, index + 1) || dfs(board, cword, visited, i, j - 1, index + 1)) {
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}