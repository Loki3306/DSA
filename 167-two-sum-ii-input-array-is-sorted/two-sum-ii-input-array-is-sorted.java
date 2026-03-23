class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1 ;

        while(left < right){
            int sum = nums[left] + nums[right];
            if( sum > target) right--;
            else if(sum < target) left++;
            else{
                int[] res = new int[2];
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
        }

        return new int[2];
    }
}