class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        answer(nums,0,result,new ArrayList<>());
        return result;
    }

    public void answer(int[] nums,int index,List<List<Integer>> result, List<Integer> list){
        if(index== nums.length){
            if(!result.contains(list))
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        answer(nums,index+1,result,list);
        list.remove(list.size()-1);
        answer(nums,index+1,result,list);
    }
}