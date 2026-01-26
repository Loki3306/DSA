class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int diff = 0;
        int minDiff = Integer.MAX_VALUE;

        for(int i=0;i<arr.length-1;i++){
            diff = Math.abs(arr[i]-arr[i+1]);
            minDiff = Math.min(diff,minDiff);
        }

        List<List<Integer>> ans = new ArrayList<>();

        int left = 0;
        int right = 1;

        for(int i=0;i<arr.length-1;i++){
            if(Math.abs(arr[i] - arr[i+1]) == minDiff){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                ans.add(list);
            }
        }

        return ans;
    }
}