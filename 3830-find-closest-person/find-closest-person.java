class Solution {
    public int findClosest(int x, int y, int z) {
        long d1=Math.abs(z-x);
        long d2=Math.abs(z-y);

        if(d1 < d2) return 1;
        else if ( d2 < d1 ) return 2;
        else return 0; 
    }
}