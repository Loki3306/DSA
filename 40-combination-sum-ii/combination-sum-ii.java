class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,result,new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums,int target,int index,List<List<Integer>> result,List<Integer> list){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=index;i<nums.length;i++){
            if(i> index && nums[i]==nums[i-1]) continue;
            if(nums[i] > target) break;

            list.add(nums[i]);
            backtrack(nums,target-nums[i],i+1,result,list);
            list.remove(list.size()-1);
        }
    }
}