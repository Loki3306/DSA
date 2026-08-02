class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int[] visited = new int[rooms.size()];
        visited[0]=1;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0;i<len;i++){
                int curr = q.poll();

                for(int j=0;j<rooms.get(curr).size();j++){
                    if(visited[rooms.get(curr).get(j)] != 1){
                        visited[rooms.get(curr).get(j)] = 1;
                        q.offer(rooms.get(curr).get(j));
                    }
                }    
            }
        }

        for(int i=0;i<visited.length;i++){
            if(visited[i] != 1) return false;
        }

        return true;
    }
}