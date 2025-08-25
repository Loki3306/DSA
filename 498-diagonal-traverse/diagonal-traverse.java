class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] ans = new int[n * m];
        boolean dir = true;
        int row = 0, col = 0, idx = 0;
        
        while (idx < n * m) {
            ans[idx] = mat[row][col];
            idx++;
            
            if (idx == n * m) break;
            
            if (dir) {
                if (row == 0 && col == m - 1) {
                    row++;
                    dir = false;
                } else if (row == 0) {
                    col++;
                    dir = false;
                } else if (col == m - 1) {
                    row++;
                    dir = false;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == n - 1 && col == 0) {
                    col++;
                    dir = true;
                } else if (row == n - 1) {
                    col++;
                    dir = true;
                } else if (col == 0) {
                    row++;
                    dir = true;
                } else {
                    row++;
                    col--;
                }
            }
        }
        
        return ans;
    }
}