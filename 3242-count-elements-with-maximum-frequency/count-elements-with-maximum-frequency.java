class Solution {
  public int maxFrequencyElements(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }

    int candidate_count = -1;
    int ans = 0;

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int key = entry.getKey();
      int value = entry.getValue();

      if (value > candidate_count) {
        ans = value;
        candidate_count = value;
      } else if (value == candidate_count) {
        ans += value;
      } else {
        continue;
      }
    }
  

  return ans;
}
}