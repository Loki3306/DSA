class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }

        if(k>=n) return max;

        if(k==1){
            int max2 = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                if(map.get(nums[i]) == 1) max2 = Math.max(max2,nums[i]);
            }

            if(max2 == Integer.MIN_VALUE) return -1;
            else return max2;
        }


        int max3 = Integer.MIN_VALUE;
        if(map.get(nums[0]) == 1) max3 = Math.max(nums[0],max3);
        if(map.get(nums[n-1]) == 1) max3 = Math.max(nums[n-1],max3);

        return max3 == Integer.MIN_VALUE ? -1 : max3;        
    }
}