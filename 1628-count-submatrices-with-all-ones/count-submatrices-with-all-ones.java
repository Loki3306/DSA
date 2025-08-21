class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] hori = new int[n][m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    if (j == 0) {
                        hori[i][j] = 1;
                    } else {
                        hori[i][j] = 1 + hori[i][j - 1];
                    }

                    int min = hori[i][j];
                    for (int k = i; k >= 0; k--) {
                        if (hori[k][j] == 0) {
                            break;
                        } 
                        if( min > hori[k][j]){
                            min=hori[k][j];
                        }
                        ans += min;
                    }

                }
            }
        }

        return ans;

    }
}