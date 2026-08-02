class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> outerList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            outerList.add(list);
        }

        for (int i = 0; i < edges.length; i++) {
            outerList.get(edges[i][0]).add(edges[i][1]);
            outerList.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int curr = q.poll();
                for (int j = 0; j < outerList.get(curr).size(); j++) {
                    if (!visited[outerList.get(curr).get(j)]) {
                        q.offer(outerList.get(curr).get(j));
                        visited[outerList.get(curr).get(j)] = true;
                    }
                }
            }

        }

        return visited[source] && visited[destination];
    }
}