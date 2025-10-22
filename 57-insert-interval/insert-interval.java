class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int n = intervals.length;

        int index = 0;

        while(index < n && intervals[index][1] < newInterval[0] ){
            list.add(intervals[index]);
            index++;
        }

        while(index < n && intervals[index][0] <= newInterval[1] ){
            newInterval[0]= Math.min(newInterval[0], intervals[index][0]);
            newInterval[1]= Math.max(newInterval[1], intervals[index][1]);
            index++;
        }

        list.add(newInterval);

        while(index < n){
            list.add(intervals[index]);
            index++;
        }


        return list.toArray(new int[list.size()][]);
    }
}