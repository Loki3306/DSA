class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){

            int candidate=nums1[i];
            boolean found=false;

            for(int j=0;j<nums2.length;j++){
                if(nums2[j] == candidate){
                    found=true;
                }
                if(found && nums2[j] >candidate){
                    result[i]=nums2[j];
                    found=false;
                    break;
                }
            }
            if(found){
                result[i]=-1;
            }
        }

        return result;
    }
}