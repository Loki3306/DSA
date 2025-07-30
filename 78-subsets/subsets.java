class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> list=new ArrayList<>();
        int subsets=1<<nums.length;

        for(int i=0;i<subsets;i++){
            List<Integer> temp=new ArrayList<>();

            for(int j=0;j<nums.length;j++){
                if((i & (1<<j)) != 0) temp.add(nums[j]); 
            }

            list.add(temp);
        }

        return list;

    }
}