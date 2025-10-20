class Solution {
    public int jump(int[] nums) {
        int index=0;
        int jump=0;
        int n=nums.length-1;

        while(index < n){
            if(index + nums[index] >= n) return ++jump;
            index=bestIndex(index,nums);
            jump++;
        }

        return jump;
    }

    public int bestIndex(int index,int[] nums){
        int idx=index;

        for(int i=index+1;i<=index+nums[index] && i<nums.length ;i++){
            
            if( i+nums[i] > idx+nums[idx]){
                idx=i;
            }

        }

        return idx;
    }
}