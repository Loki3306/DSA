import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n=grid.length;
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int d=i-j;
                map.computeIfAbsent(d,k->new ArrayList<>()).add(grid[i][j]);
            }
        }
        for(int d:map.keySet()){
            if(d>=0) map.get(d).sort(Collections.reverseOrder());
            else Collections.sort(map.get(d));
        }
        Map<Integer,Integer> idx=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int d=i-j;
                int k=idx.getOrDefault(d,0);
                grid[i][j]=map.get(d).get(k);
                idx.put(d,k+1);
            }
        }
        return grid;
    }
}
