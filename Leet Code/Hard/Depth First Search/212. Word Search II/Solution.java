/* Given an m x n board of characters and a list of strings words, return all words on the board. Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example 1:
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

Example 2:
Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []

Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 10^4
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.
    
Link: https://leetcode.com/problems/word-search-ii/ */

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        
        for(String word : words) {
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    
                    boolean[][] visited = new boolean[m][n];
                    if(word.charAt(0) == board[i][j]) {
                        
                        if(dfs(board, word, 0, i, j, visited)) {
                            set.add(word);
                        }
                        
                    }
                }
            }
        }
        
        return new ArrayList<>(set);
    }
    
    private boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if(word.length() == index) {
            return true;
        }
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j] || visited[i][j]) {
            return false;
        }
        
        boolean result = false;
        visited[i][j] = true;
        
        result = dfs(board, word, index + 1, i + 1, j, visited) || dfs(board, word, index + 1, i - 1, j, visited) || dfs(board, word, index + 1, i, j + 1, visited) || dfs(board, word, index + 1, i, j - 1, visited);
        
        visited[i][j] = false;
        
        return result;
    }
}