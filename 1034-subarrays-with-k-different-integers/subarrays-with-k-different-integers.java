class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums,k)-solve(nums,k-1);
    }

    public int solve(int[] nums,int k){
        int left=0;
        int cnt=0;
        int dsnt=0; //distinct
        int[] freq=new int[100001];
        for(int right=0;right<nums.length;right++){
            if(freq[nums[right]] ==0) dsnt++;
            freq[nums[right]]++;    

            while(dsnt > k){
                freq[nums[left]]--;
                if(freq[nums[left]] == 0) dsnt--;
                left++;
            }

            cnt+=right-left+1;
        }

        return cnt;
    }
}