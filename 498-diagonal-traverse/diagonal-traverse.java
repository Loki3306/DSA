class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] ans = new int[n * m];
        int row = 0, col = 0, idx = 0;

        while (idx < n * m) {
            ans[idx++] = mat[row][col];

            if ((row + col) % 2 == 0) { 
                if (col == m - 1) row++;
                else if (row == 0) col++;
                else { row--; col++; }
            } else { 
                if (row == n - 1) col++;
                else if (col == 0) row++;
                else { row++; col--; }
            }
        }

        return ans;
    }
}
