class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos=0,neg=1;
        int[] temp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i] >0){
                temp[pos]=nums[i];
                pos+=2;    
            }

            else{
                temp[neg]=nums[i];
                neg+=2;
            }
        }

        return temp;
    }
}