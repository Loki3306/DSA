class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0,right=n-1;
        int ans=0;
        
        while(left < right){
            if(height[left] < height[right]){
                ans=Math.max(ans, height[left]*(right-left));
                left++;
            }else{
                ans=Math.max(ans, height[right]*(right-left));
                right--;
            }
        }

        return ans;
    }
}