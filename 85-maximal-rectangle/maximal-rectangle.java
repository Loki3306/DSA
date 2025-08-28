class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        if(n==0) return 0;
        int[] heights=new int[m];
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    heights[j]+=1;
                }
                else{
                    heights[j]=0;
                }
            }
            max=Math.max(max,area(heights));
        }   
        return max;
    }

    public int area(int[] nums){
        int n=nums.length;
        int max=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<=n;i++){
            int ht= (i==n)? 0:nums[i];
            while(!st.isEmpty() && ht < nums[st.peek()]){
                int h=nums[st.pop()];
                int w= st.isEmpty() ? i: i-st.peek()-1;
                max=Math.max(max,h*w);
            }
            st.push(i);
        }

        return max;
    }
}