class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] prefix=new int[n];
        int[] suffix=new int[n];

        prefix[0]=height[0];
        suffix[n-1]=height[n-1];

        for(int i=1,j=n-2; i<n && j>=0; i++,j--){
            prefix[i]=Math.max(prefix[i-1],height[i]);
            suffix[j]=Math.max(suffix[j+1],height[j]);
        }

        int ans=0;
        for(int i=0;i<n;i++){
            ans += Math.min(prefix[i], suffix[i]) - height[i];
        }

        return ans;
    }
}
