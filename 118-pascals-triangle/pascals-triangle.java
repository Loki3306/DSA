class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> outerList=new ArrayList<>();

        for(int i=0;i<numRows;i++){
            List<Integer> list=new ArrayList<>();

            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    list.add(1);
                }
                else{
                    int curr=outerList.get(i-1).get(j-1) + outerList.get(i-1).get(j);
                    list.add(curr);
                }
            }
            outerList.add(list);

        }

        return outerList;
    }
}