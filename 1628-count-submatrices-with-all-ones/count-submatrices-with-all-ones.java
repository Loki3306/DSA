class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] helper = new int[n][m];
        int ans=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    if (j == 0) {
                        helper[i][j] = 1;
                    } else {
                        helper[i][j] = 1 + helper[i][j - 1];
                    }

                    int min=helper[i][j];
                    for(int k=i;k>=0;k--){
                        if(mat[k][j]==0) break;
                        if(min > helper[k][j]) min=helper[k][j];
                        ans+=min;
                    }

                }
            }
        }

        return ans;
    }
}