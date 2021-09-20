/* Tic-tac-toe is played by two players A and B on a 3 x 3 grid. Here are the rules of Tic-Tac-Toe:
Players take turns placing characters into empty squares (" ").
The first player A always places "X" characters, while the second player B always places "O" characters.
"X" and "O" characters are always placed into empty squares, never on filled ones.
The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.

Given an array moves where each element is another array of size 2 corresponding to the row and column of the grid where they mark their respective character in the order in which A and B play. Return the winner of the game if it exists (A or B), in case the game ends in a draw return "Draw", if there are still movements to play return "Pending". You can assume that moves is valid (It follows the rules of Tic-Tac-Toe), the grid is initially empty and A will play first.

Example 1:
Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: "A" wins, he always plays first.
"X  "    "X  "    "X  "    "X  "    "X  "
"   " -> "   " -> " X " -> " X " -> " X "
"   "    "O  "    "O  "    "OO "    "OOX"

Example 2:
Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
Output: "B"
Explanation: "B" wins.
"X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
"   " -> " O " -> " O " -> " O " -> "XO " -> "XO " 
"   "    "   "    "   "    "   "    "   "    "O  "

Example 3:
Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
Output: "Draw"
Explanation: The game ends in a draw since there are no moves to make.
"XXO"
"OOX"
"XOX"

Example 4:
Input: moves = [[0,0],[1,1]]
Output: "Pending"
Explanation: The game has not finished yet.
"X  "
" O "
"   "

Constraints:
1 <= moves.length <= 9
moves[i].length == 2
0 <= moves[i][j] <= 2
There are no repeated elements on moves.
moves follow the rules of tic tac toe.
    
Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3981/ */

class Solution {
    public String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];
        int n = moves.length;
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                board[moves[i][0]][moves[i][1]] = 'X';
            } else {
                board[moves[i][0]][moves[i][1]] = 'O';
            }
        }
        
        return checkBoard(board);
    }
    
    private String checkBoard(char[][] board) {
        
        for(int i = 0; i < board.length; i++) {
            int countA = 0;
            int countB = 0;
            
            for(int j = 0; j < board.length; j++) {
                
                if(board[i][j] == 'X') countA++;
                else if(board[i][j] == 'O') countB++;
            
            }
            
            if(countA == 3) return "A";
            else if(countB == 3) return "B";
        }
        
        for(int i = 0; i < board.length; i++) {
            int countA = 0;
            int countB = 0;
            
            for(int j = 0; j < board.length; j++) {
                
                if(board[j][i] == 'X') countA++;
                if(board[j][i] == 'O') countB++;
            }
            
            if(countA == 3) return "A";
            if(countB == 3) return "B";
        }
        
        if(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') return "A";
        if(board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') return "B";
        
        if(board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') return "A";
        if(board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') return "B";
        
        int count = 0;
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if((board[i][j] == 'X') || (board[i][j] == 'O')) count++;
            }
        }
        
        if(count == 9) return "Draw";
        
        return "Pending";
    }
}