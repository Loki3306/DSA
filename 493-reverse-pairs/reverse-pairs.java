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
        cnt += countPairs(nums, low, mid, high); // ✅ fix
        merge(nums, low, mid, high);              // ✅ just merge
        return cnt;
    }

    public int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long)arr[i] > 2L * arr[right]) right++; // ✅ avoid overflow
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    public void merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        List<Integer> list = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                list.add(nums[left++]);
            } else {
                list.add(nums[right++]);
            }
        }

        while (left <= mid) list.add(nums[left++]);
        while (right <= high) list.add(nums[right++]);

        for (int i = low; i <= high; i++) {
            nums[i] = list.get(i - low);
        }
    }
}
