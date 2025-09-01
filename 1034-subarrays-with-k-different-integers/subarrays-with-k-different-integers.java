class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums,k)-solve(nums,k-1);
    }

    public int solve(int[] nums,int k){
        int left=0;
        Map<Integer,Integer> map=new HashMap<>();
        int cnt=0;
        for(int right=0;right<nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0) + 1);

            while(map.size() > k){
                map.put(nums[left],map.getOrDefault(nums[left],0)-1);
                if(map.get(nums[left]) ==0) map.remove(nums[left]);
                left++;
            }

            cnt+=right-left+1;

        }

        return cnt;
    }
}