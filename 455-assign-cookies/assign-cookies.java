class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int cookieIndex=0;
        int childIndex=0;

        while(cookieIndex < s.length && s[cookieIndex] < g[childIndex] ) cookieIndex++;

        if(cookieIndex == s.length ) return 0;
        int cnt=0;
        while(childIndex  < g.length && cookieIndex < s.length ){
            if(g[childIndex] <= s[cookieIndex]){
                cnt++;
                childIndex++;
                cookieIndex++;
            } 
            else{
                cookieIndex++;
            }
        }



        return cnt;
    }
}