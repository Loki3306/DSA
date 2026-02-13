class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map = new HashMap<>();
        int size = tasks.length;
        for(int i=0;i<size;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int count : map.values()){
            maxHeap.add(count);
        }

        int time = 0;
        while(!maxHeap.isEmpty()){
            List<Integer> list = new ArrayList<>();

            int cyc = n+1;


            int i =0;

            while(i<cyc && !maxHeap.isEmpty()){
                int cnt = maxHeap.poll();
                
                cnt --;
                
                if(cnt > 0){
                    list.add(cnt);
                }

                time++;
                i++;
            }

            for (int rem : list) {
                maxHeap.add(rem);
            }

                if (!maxHeap.isEmpty()) {
                time += (cyc - i);
            }
        }

        return time;
    }
}