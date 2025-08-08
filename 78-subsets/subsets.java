class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        generate(0,new ArrayList<>(),result,nums);
        return result;
    }

    public void generate(int index,List<Integer> current,List<List<Integer>> result,int[] nums){
        result.add(new ArrayList<>(current));

        for(int i=index;i<nums.length;i++){
            current.add(nums[i]);
            generate(i+1,current,result,nums);
            current.remove(current.size()-1);
        }
    }
}