class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] ans = new int[n * m];
        int row = 0, col = 0, idx = 0;
        boolean dir = true;

        while (idx < n * m) {
            ans[idx++] = mat[row][col];

            if (dir) {
                if (row == 0 && col != m - 1) col++;
                else if (col == m - 1) row++;
                else { row--; col++; }
            } else { 
                if (col == 0 && row != n - 1) row++;
                else if (row == n - 1) col++;
                else { row++; col--; }
            }

            dir = (row + col) % 2 == 0; 
        }

        return ans;
    }
}
