import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        for (int start = 0; start < n; start++) {
            List<Integer> diag = new ArrayList<>();
            for (int i = start, j = 0; i < n && j < n; i++, j++) diag.add(grid[i][j]);
            if (start >= 0) diag.sort(Collections.reverseOrder());
            for (int i = start, j = 0, k = 0; i < n && j < n; i++, j++, k++) grid[i][j] = diag.get(k);
        }

        for (int start = 1; start < n; start++) {
            List<Integer> diag = new ArrayList<>();
            for (int i = 0, j = start; i < n && j < n; i++, j++) diag.add(grid[i][j]);
            diag.sort(null);
            for (int i = 0, j = start, k = 0; i < n && j < n; i++, j++, k++) grid[i][j] = diag.get(k);
        }

        return grid;
    }
}
