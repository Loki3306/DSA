class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==1) return true;
        if( n <= 0) return false;

        int cnt=0;


        while(n!=0){
            if((n&1) ==1 ) cnt++;
            if(cnt == 2) return false;
            n>>=1;
        }

        return true;
    }
}