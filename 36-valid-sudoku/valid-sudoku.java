import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;

        // check rows
        for(int i=0;i<n;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<n;j++){
                if(board[i][j] != '.'){
                    if(set.contains(board[i][j])) return false;
                    set.add(board[i][j]);
                }
            }
        }

        // check columns
        for(int i=0;i<n;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<n;j++){
                if(board[j][i] != '.'){
                    if(set.contains(board[j][i])) return false;
                    set.add(board[j][i]);
                }
            }
        }

        
        for(int row=0;row<9;row+=3){
            for(int col=0;col<9;col+=3){
                HashSet<Character> set = new HashSet<>();
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        char c = board[row+i][col+j];
                        if(c != '.'){
                            if(set.contains(c)) return false;
                            set.add(c);
                        }
                    }
                }
            }
        }

        return true;
    }
}
