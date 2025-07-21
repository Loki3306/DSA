class Solution {
    public int search(int[] nums, int target) {

        if (nums.length == 1) {
            if (nums[0] == target)
                return 0;
            else
                return -1;
        }

        if (nums.length == 0)
            return -1;

        int pivot = pivot(nums);
        int result = -1;

        if (target >= nums[0]) {
            result = search(nums, target, 0, pivot);
        }

        else {
            result = search(nums, target, pivot + 1, nums.length - 1);
        }

        return result;
    }

    public int search(int[] nums, int target, int s, int e) {

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                e = mid - 1;
            }

            if (nums[mid] < target) {
                s = mid + 1;
            }
        }

        return -1;
    }

    public int pivot(int[] nums) {
        int s = 0, e = nums.length - 1;
        if (nums[s] < nums[e])
            return e;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (mid == 0 && nums[0] > nums[1])
                return 0;

            if (mid > 0 && mid < nums.length - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (mid == nums.length - 1 && nums[mid] > nums[mid - 1])
                return mid;

            if (nums[mid] >= nums[0]) {
                s = mid + 1;
            }

            if (nums[mid] < nums[0]) {
                e = mid - 1;
            }
        }
        return -1;
    }

}