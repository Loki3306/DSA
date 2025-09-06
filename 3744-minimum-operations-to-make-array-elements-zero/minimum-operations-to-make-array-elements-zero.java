class Solution {
    public long minOperations(int[][] queries) {
        long total=0;
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            long sum=rangeSteps(l,r);
            total+= (sum+1)/2;
        }
        return total;
    }

    public long rangeSteps(int l,int r){
        return prefixSteps(r)-prefixSteps(l-1);
    }

    public long prefixSteps(int n){
        if(n<=0) return 0;
        long res=0;
        long start=1;
        int step=1;
        while(start<=n){
            long end=Math.min((long)Math.pow(4,step)-1,n);
            long count=end-start+1;
            res+=count*step;
            start*=4;
            step++;
        }
        return res;
    }
}
