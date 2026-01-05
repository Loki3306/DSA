class Solution {
    public int majorityElement(int[] nums) {
         int candidate=nums[0];
         int cnt=1;
         int n=nums.length;

         for(int i=1;i<n;i++){
            if(nums[i]==candidate) cnt++;
            else cnt--;

            if(cnt == 0){
                candidate=nums[i];
                cnt=1;
            }
         }

        return candidate;

         
    }
}
