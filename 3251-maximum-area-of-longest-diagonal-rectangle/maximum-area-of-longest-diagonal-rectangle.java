class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double ans = -1;
        int idx = 0;

        for(int i=0; i<dimensions.length; i++){
            double dia = Math.sqrt(Math.pow(dimensions[i][0],2) + Math.pow(dimensions[i][1],2));

            if(dia > ans){
                ans = dia;
                idx = i;
            } else if(dia == ans){ 
                if(dimensions[i][0] * dimensions[i][1] > dimensions[idx][0] * dimensions[idx][1]){
                    idx = i;
                }
            }
        }

        return dimensions[idx][0] * dimensions[idx][1];
    }
}
