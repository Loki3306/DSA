class Solution {
    public int[][] merge(int[][] intervals) {   
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        list.add(Arrays.asList(intervals[0][0],intervals[0][1]));

        for(int i=1;i<intervals.length;i++){
            int lastStart=list.get(list.size()-1).get(0);
            int lastEnd=list.get(list.size()-1).get(1);

            int currStart=intervals[i][0];
            int currEnd=intervals[i][1];

            if(currStart <= lastEnd){
                list.set(list.size()-1,Arrays.asList(lastStart,Math.max(lastEnd,currEnd)));
            }
            else{
                list.add(Arrays.asList(currStart,currEnd));
            }
        }

        int[][] arr=new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            arr[i][0]=list.get(i).get(0);
            arr[i][1]=list.get(i).get(1);
        }


        return arr;

    }
}