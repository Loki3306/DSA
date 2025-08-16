class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<>();
        
        boolean[] leftRow = new boolean[n];
        boolean[] upperDiagonal = new boolean[2 * n - 1];
        boolean[] lowerDiagonal = new boolean[2 * n - 1];

        dfs(0, board, res, leftRow, upperDiagonal, lowerDiagonal);
        return res;
    }

    static void dfs(int col, char[][] board, List<List<String>> res,
                    boolean[] leftRow, boolean[] upperDiagonal, boolean[] lowerDiagonal) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (!leftRow[row] && !lowerDiagonal[row + col] && !upperDiagonal[board.length - 1 + col - row]) {
                board[row][col] = 'Q';
                leftRow[row] = true;
                lowerDiagonal[row + col] = true;
                upperDiagonal[board.length - 1 + col - row] = true;

                dfs(col + 1, board, res, leftRow, upperDiagonal, lowerDiagonal);

                board[row][col] = '.';
                leftRow[row] = false;
                lowerDiagonal[row + col] = false;
                upperDiagonal[board.length - 1 + col - row] = false;
            }
        }
    }

    static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++)
            res.add(new String(board[i]));
        return res;
    }
}
