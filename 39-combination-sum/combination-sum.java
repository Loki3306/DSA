import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index, int remain, List<Integer> path, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (remain < 0 || index == nums.length) {
            return;
        }

        
        path.add(nums[index]);
        backtrack(nums, index, remain - nums[index], path, result);
        path.remove(path.size() - 1); 

    
        backtrack(nums, index + 1, remain, path, result);
    }
}
