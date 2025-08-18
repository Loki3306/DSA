class Solution {
    public boolean judgePoint24(int[] cards) {
        double[] nums=new double[cards.length];
        for(int i=0;i<cards.length;i++) nums[i]=cards[i];
        return backtrack(nums, nums.length);
    }

    private boolean backtrack(double[] nums, int n) {
        if (n == 1) return Math.abs(nums[0] - 24) < 1e-6;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {  // ✅ avoid duplicates
                double a = nums[i], b = nums[j];

                double[] candidates = {
                    a + b,
                    a - b,
                    b - a,
                    a * b,
                    b != 0 ? a / b : Double.NaN,
                    a != 0 ? b / a : Double.NaN
                };

                for (double val : candidates) {
                    if (Double.isNaN(val)) continue;
                    if (Math.abs(val) > 1e6) continue;  // ✅ pruning

                    nums[j] = val;
                    nums[i] = nums[n - 1];  // replace i with last element
                    if (backtrack(nums, n - 1)) return true;
                    nums[i] = a;  // restore
                    nums[j] = b;  // restore
                }
            }
        }
        return false;
    }
}
