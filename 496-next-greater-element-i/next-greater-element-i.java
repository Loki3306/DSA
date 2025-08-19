class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        int[] result=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int can=nums1[i];
            for(int j=0;j<nums2.length;j++){
                if(nums2[j]==can){
                    st.push(can);
                }
                if(!st.isEmpty()){
                    if(nums2[j] > st.peek()){
                        st.push(nums2[j]);
                        break;
                    }
                }
            }
            if(st.peek() != can){
                result[i]=st.pop();
                st.pop();
            }else{
                st.pop();
                result[i]=-1;
            }
        }

        return result;
    }
}