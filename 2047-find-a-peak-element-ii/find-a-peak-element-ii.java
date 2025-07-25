class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int leftCol = 0;
        int rightCol = n - 1;

        while (leftCol <= rightCol) {
            int midCol = leftCol + (rightCol - leftCol) / 2;
            int maxRowInMidCol = 0;

            // Find the row with the maximum element in the current midCol
            for (int i = 0; i < m; i++) {
                if (mat[i][midCol] > mat[maxRowInMidCol][midCol]) {
                    maxRowInMidCol = i;
                }
            }

            int currentVal = mat[maxRowInMidCol][midCol];

            // Get left neighbor value (consider -1 if out of bounds)
            int leftNeighbor = (midCol > 0) ? mat[maxRowInMidCol][midCol - 1] : -1;

            // Get right neighbor value (consider -1 if out of bounds)
            int rightNeighbor = (midCol < n - 1) ? mat[maxRowInMidCol][midCol + 1] : -1;

            // Check if currentVal is a peak
            if (currentVal > leftNeighbor && currentVal > rightNeighbor) {
                return new int[]{maxRowInMidCol, midCol};
            }
            // If left neighbor is greater, search in the left half
            else if (leftNeighbor > currentVal) {
                rightCol = midCol - 1;
            }
            // If right neighbor is greater, search in the right half
            else {
                leftCol = midCol + 1;
            }
        }
        return new int[]{-1, -1}; // Should not reach here given problem constraints
    }
}