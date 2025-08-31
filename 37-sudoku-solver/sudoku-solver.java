class Solution {
    boolean[][] rowUsed = new boolean[9][9];
    boolean[][] colUsed = new boolean[9][9];
    boolean[][] boxUsed = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    boxUsed[(i / 3) * 3 + j / 3][num] = true;
                }
            }
        }
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int i, int j) {
        if (i == 9)
            return true;
        int nextI = i + (j + 1) / 9;
        int nextJ = (j + 1) % 9;
        if (board[i][j] != '.')
            return solve(board, nextI, nextJ);
        for (int num = 0; num < 9; num++) {
            if (!rowUsed[i][num] && !colUsed[j][num] && !boxUsed[(i / 3) * 3 + j / 3][num]) {
                board[i][j] = (char) (num + '1');
                rowUsed[i][num] = true;
                colUsed[j][num] = true;
                boxUsed[(i / 3) * 3 + j / 3][num] = true;
                if (solve(board, nextI, nextJ))
                    return true;
                board[i][j] = '.';
                rowUsed[i][num] = false;
                colUsed[j][num] = false;
                boxUsed[(i / 3) * 3 + j / 3][num] = false;
            }
        }
        return false;
    }
}
