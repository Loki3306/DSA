class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result= new ArrayList<>();
        backtrack(nums,target,0,new ArrayList<>(),result);
        return result;
    }

    public void backtrack(int[] nums,int target,int index,List<Integer> list,List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(target < 0 || index == nums.length ){
            return;
        }

        list.add(nums[index]);
        backtrack(nums,target-nums[index],index,list,result);
        list.remove(list.size()-1);
        backtrack(nums,target,index+1,list,result);
    }
}