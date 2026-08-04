class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }

        //created adjcanceny list
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }

        int[] vis = new int[n];

        int cnt = 0;
        int ans = 0;
        int node_choosen = 0;
        
        while(cnt != n){
            while(node_choosen < n && vis[node_choosen] == 1){
                cnt++;
                node_choosen++;
            }

            if(cnt >= n) break;

            dfs(node_choosen,vis,adj);
            ans++;
        }
        
        return ans;
    }

    public void dfs(int node,int[] vis,List<List<Integer>> adj){
        vis[node] = 1;

        for(int i=0;i<adj.get(node).size();i++){
            if(vis[adj.get(node).get(i)] != 1) dfs(adj.get(node).get(i),vis,adj);
        }
    }
}