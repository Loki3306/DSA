class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];

        List<Integer> list = new ArrayList<>();
        for(int i=min+1;i<max;i++){
            list.add(i);
        }
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<list.size();i++){
            int ind = Arrays.binarySearch(nums,list.get(i));
            if(ind >= 0) list.set(i,0);
        }

        for(int i=0;i<list.size();i++){
            if(list.get(i) != 0 ){
                ans.add(list.get(i));
            }
        }

        return ans;
    }
}