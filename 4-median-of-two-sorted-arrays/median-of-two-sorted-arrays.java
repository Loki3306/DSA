class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int temp[]=new int[nums1.length + nums2.length];
        for(int i=0;i<nums1.length;i++){
            temp[i]=nums1[i];
        }

        for(int i=nums1.length;i<temp.length;i++){
            temp[i]=nums2[i-nums1.length];
        }
    
        double median=0;
        Arrays.sort(temp);
        if(temp.length % 2==0){
            median=(double)(temp[temp.length/2 -1] +temp[temp.length/2 ])/2;
        }
        else{
            median=temp[temp.length/2];
        }

        return median;
    }
}