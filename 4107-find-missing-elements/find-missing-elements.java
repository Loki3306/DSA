class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }

        boolean[] bool = new boolean[max-min+1];
        for(int i=0;i<nums.length;i++){
            bool[nums[i] - min] = true;
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<bool.length;i++){
            if(!bool[i]) list.add(i+min);
        }

        return list;
    }
}