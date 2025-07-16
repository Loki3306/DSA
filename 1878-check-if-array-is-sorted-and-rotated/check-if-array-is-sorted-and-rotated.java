class Solution {
    public boolean check(int[] nums) {
        int pivot = pivot(nums);



        if(nums.length==2 || nums.length==1 || nums.length==0 ) return true;


        if(pivot==0 && (nums[1] >= nums[0])){
            boolean sorted=isSorted(nums,0,nums.length-1);
            if(sorted==true) return true;
            else return false;
        }

        if(pivot==0){
            boolean sorted3=isSorted(nums,pivot+1,nums.length-1);
            if(sorted3==true && (nums[0] >= nums[nums.length-1])) return true;

            return false;
        }

         

        boolean sorted1 = isSorted(nums, 0, pivot);
        boolean sorted2 = isSorted(nums, pivot + 1, nums.length - 1);

        if (sorted1 == true && sorted2 == true && (nums[0] >= nums[nums.length-1]))
            return true;

        return false;
    }

    public int pivot(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] < 0) {
                index = i;
                break;
            }
        }

        return index;
    }

    public boolean isSorted(int[] nums, int startIndex, int endIndex) {
        for (int i = startIndex+1; i <= endIndex ; i++) {
            if (nums[i ] - nums[i-1] < 0) {
                return false;
            }
        }
        return true;
    }
}