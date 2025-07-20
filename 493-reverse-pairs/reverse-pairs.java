class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int low, int high) {
        int cnt = 0;
        if (low >= high)
            return cnt;
        int mid = low + (high - low) / 2;
        cnt += mergeSort(nums, low, mid);
        cnt += mergeSort(nums, mid + 1, high);
        cnt += merge(nums, low, mid, high);

        return cnt;

    }

    public int merge(int[] nums, int low, int mid, int high) {
        int cnt = 0;
        int left = low;
        int right = mid + 1;
        List<Integer> list = new ArrayList<>();
        int j = mid + 1;

        // Count reverse pairs
        for (int i = low; i <= mid; i++) {
            while (j <= high && (long)nums[i] > 2L * nums[j]) {
                j++;
            }
            cnt += j - (mid + 1);
        }

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                list.add(nums[left]);
                left++;

            } else {
                list.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            list.add(nums[left++]);
        }
        while (right <= high) {
            list.add(nums[right++]);
        }

        for (int i = low; i <= high; i++) {
            nums[i] = list.get(i - low);
        }

        return cnt;
    }

}