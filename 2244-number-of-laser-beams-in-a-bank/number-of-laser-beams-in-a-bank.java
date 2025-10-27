class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int ans = 0;
        for(String row : bank){
            int ones = (int)row.chars().filter(ch -> ch == '1').count();
            if(ones > 0){
                ans += prev * ones;
                prev = ones;
            }
        }
        return ans;
    }
}
