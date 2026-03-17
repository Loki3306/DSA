class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < n1; i++) {
            set1.add(nums1[i]);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < n2; i++) {
            set2.add(nums2[i]);
        }

        set1.retainAll(set2);

        int[] ans = new int[set1.size()];
        int i = 0;

        for (int x : set1) {
            ans[i++] = x;
        }

        return ans;

    }
}