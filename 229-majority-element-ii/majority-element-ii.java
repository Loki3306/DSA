class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        int candidate=nums[0];
        int cnt=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] == candidate){
                cnt++;
            }
            else{
                if(cnt> nums.length/3 && !list.contains(nums[i])){
                    list.add(candidate);
                }
                candidate=nums[i];
                cnt=1;
            }
        }

        cnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == candidate) cnt++;
        }
        if(cnt > nums.length/3 ) list.add(candidate);

        return list;
    }
}