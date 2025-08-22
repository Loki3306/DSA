class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int top = -1, bottom = -1, left = -1, right = -1;

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    top = i;
                    break;
                }
            }
            if (top != -1) break;
        }

        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    bottom = i;
                    break;
                }
            }
            if (bottom != -1) break;
        }

        
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 1) {
                    left = j;
                    break;
                }
            }
            if (left != -1) break;
        }

        
        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 1) {
                    right = j;
                    break;
                }
            }
            if (right != -1) break;
        }

        if (top == -1) return 0; 
        return (bottom - top + 1) * (right - left + 1);
    }
}
