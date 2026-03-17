class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet <Integer> set = new HashSet <>();
        ArrayList <Integer> list= new ArrayList<>();
        for(int val: nums1)
        {
            set.add(val);
        }
        for (int val: nums2)
        {
            if(set.contains(val))
            {
                list.add(val);
                set.remove(val);
            }
        }
        int arr[] = new int [list.size()];
        for (int i=0;i<list.size();i++)
        {
            arr[i]=list.get(i);
        }
        return arr;
    }
}