class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long total=0, streak=0;
        for(int x:nums){
            if(x==0){
                streak++;
                total+=streak;
            }else{
                streak=0;
            }
        }
        return total;
    }
}
