class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] temp = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j]==1){
                if (i == 0 || j == 0) {
                    temp[i][j] = 1;
                } else {
                    temp[i][j] = 1 + Math.min(temp[i - 1][j], Math.min(temp[i][j - 1], temp[i - 1
                    ][j - 1]));
                }
                ans += temp[i][j];
                }
            }

        }

        return ans;
    }
}