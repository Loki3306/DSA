class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 1;
        int cand = nums[0];

        for(int i = 1;i<nums.length;i++){
            if(cnt == 0){
                cnt = 1;
                cand = nums[i];
            }

            else if(nums[i] == cand) cnt ++;
            else cnt --;
        }

        return cand;
    }
}