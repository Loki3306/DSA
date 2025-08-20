class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] memo = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                memo[i][j] = -1;  
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += helper(matrix, i, j, memo); 
            }
        }

        return ans;
    }

    public int helper(int[][] mat, int i, int j, int[][] memo) {
        if (i >= mat.length || j >= mat[0].length)
            return 0;
        if (mat[i][j] == 0)
            return 0;

        if (memo[i][j] != -1)
            return memo[i][j];

        int right = helper(mat, i, j + 1, memo);
        int down = helper(mat, i + 1, j, memo);
        int diag = helper(mat, i + 1, j + 1, memo);

        return memo[i][j] = 1 + Math.min(right, Math.min(down, diag));
    }
}
