class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int i, int j, int index) {
        // out of bounds
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;

        // mismatch
        if (board[i][j] != word.charAt(index)) return false;

        // last character matched
        if (index == word.length() - 1) return true;

        // mark visited
        char temp = board[i][j];
        board[i][j] = '!';

        // explore 4 directions
        boolean found = backtrack(board, word, i + 1, j, index + 1) ||
                        backtrack(board, word, i - 1, j, index + 1) ||
                        backtrack(board, word, i, j + 1, index + 1) ||
                        backtrack(board, word, i, j - 1, index + 1);

        // unmark
        board[i][j] = temp;

        return found;
    }
}
