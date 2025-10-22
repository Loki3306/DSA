class Solution {
    public int[][] merge(int[][] nums){
        int n=nums.length;
        if(n==0) return new int[0][0];
        Arrays.sort(nums, (a,b) -> Integer.compare(a[0],b[0]));
        
        ArrayList<int[]> list=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(list.isEmpty() || list.get(list.size()-1)[1] < nums[i][0]){
                list.add(nums[i]);
            }else{
                list.get(list.size()-1)[1]=Math.max(list.get(list.size()-1)[1], nums[i][1]);
            }
        }


        return list.toArray(new int[list.size()][]);                
    }
}