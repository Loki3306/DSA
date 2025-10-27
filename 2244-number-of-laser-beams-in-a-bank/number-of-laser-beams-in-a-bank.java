class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        List<Integer> list=new ArrayList<>();

        for(int i=0;i<n;i++){
            long cnt= bank[i].chars().filter(ch -> ch == '1').count();
            if( cnt != 0 ){
                list.add((int)cnt);
            }
        }

        int ans=0;
        for(int i=0;i<list.size()-1;i++){
            ans += (list.get(i)*list.get(i+1));
        }

        return ans;
    }
}