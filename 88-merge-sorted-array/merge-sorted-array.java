class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = 0 ;
        int ptr1 = 0;
        int ptr2 = 0;
        int[] temp = new int[n+m];
        while(ptr1 < m && ptr2 < n){
            if(nums1[ptr1] < nums2[ptr2]){
                temp[idx++]=nums1[ptr1++];
            }
            else{
                temp[idx++]=nums2[ptr2++];
            }
        }
        while(ptr1 < m) temp[idx++]=nums1[ptr1++];
        while(ptr2 < n) temp[idx++]=nums2[ptr2++];

        for(int i=0;i<n+m;i++){
            nums1[i]=temp[i];
        }
    }
}