class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        answer(1, 0, result, new ArrayList<>(), n, k);
        return result;
    }

    public void answer(int number, int currSum, List<List<Integer>> result, List<Integer> list, int n, int k) {

        if (currSum == n && list.size() == k) { 
            result.add(new ArrayList<>(list));
            return;
        }

        if (number > 9)
            return;

        if (currSum > n || list.size() > k)
            return;

        if (currSum == n && list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(number);
        answer(number + 1, currSum + number, result, list, n, k);
        list.remove(list.size() - 1);
        answer(number + 1, currSum, result, list, n, k);
    }
}