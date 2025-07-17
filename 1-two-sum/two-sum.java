class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int[] soln=new int[2];

        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];

            if(map.containsKey(temp)){
                soln[0]=i;
                soln[1]=map.get(temp);
            }

            else{
                map.put(nums[i],i);
            }
        }

        return soln;
    }
}