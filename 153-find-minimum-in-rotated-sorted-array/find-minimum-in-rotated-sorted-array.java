class Solution {
    public int findMin(int[] nums) {
        int pivot=findPivot(nums);
        if(nums.length == 1) return nums[0];
        if(nums.length == 0 ) return -1;

        if(pivot == nums.length-1 ) return nums[0];
        else return nums[pivot+1]; 
    }

    public int findPivot(int[] nums) {
        int start = 0, end = nums.length - 1;

        if (nums[start] < nums[end])
            return end;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if mid is pivot
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // Check if mid-1 is pivot
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            // Left part is sorted => pivot must be in right
            if (nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1; // Pivot not found (shouldn't happen if input is valid)
    }

}