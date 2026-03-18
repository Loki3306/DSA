class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prev = new int[n];

        int prod = nums[0];
        prev[0] = 1;

        for(int i=1;i<n;i++){
            prev[i]=prod;
            prod *= nums[i];
        }

        prod = 1;
        for(int i=n-1;i>=0;i--){
            prev[i] = prev[i]*prod;
            prod *= nums[i];
        }

        return prev;
    }
}