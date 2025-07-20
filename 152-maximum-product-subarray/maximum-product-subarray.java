class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int prod = nums[i];
            maxProd = Math.max(maxProd, prod);

            for (int j = i + 1; j < nums.length; j++) {
                prod *= nums[j];
                maxProd = Math.max(prod, maxProd);
            }
        }

        return maxProd;
    }
}
