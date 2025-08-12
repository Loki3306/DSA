class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(candidates,0,target,result,new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums,int index,int target,List<List<Integer>> result,List<Integer> list){
        if(target  == 0){
            result.add(new ArrayList(list));
            return;
        }
        if(index==nums.length || target < 0){
            return;
        }

        list.add(nums[index]);
        backtrack(nums,index,target-nums[index],result,list);
        list.remove(list.size()-1);
        backtrack(nums,index+1,target,result,list);
        
    }
}