class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int ans = 0;
        for(String row : bank){
            int ones = 0;
            for(int i=0;i<row.length();i++){
                if(row.charAt(i)=='1') ones++;
            }
            if(ones>0){
                ans += prev * ones;
                prev = ones;
            }
        }
        return ans;
    }
}
