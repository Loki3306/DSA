class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[n-1];

        List<Integer> list = new ArrayList<>();

        for(int i=min+1;i<max;i++){
            int ind = Arrays.binarySearch(nums,i);
            if(ind < 0){
                list.add(i);
            }
        }

        return list;
    }
}