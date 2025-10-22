class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        ArrayList<int[]> list=new ArrayList<>();

        int index=0;
        
        // jab tk merge nahi hora tb tk list.add and index++
        while(index < n && intervals[index][1] < newInterval[0] ){
            list.add(intervals[index++]);
        }

        //merge ab
        while(index < n && intervals[index][0] <= newInterval[1] ){
            newInterval[0]=Math.min(newInterval[0],intervals[index][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[index][1]);
            index++;
        } 

        //add the merged interval
        list.add(newInterval);

        //remaining
        while(index < n){
            list.add(intervals[index++]);
        }

        return list.toArray(new int[list.size()][]);
    }
}