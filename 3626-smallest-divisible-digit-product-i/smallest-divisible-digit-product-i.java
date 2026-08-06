class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            if(solve(n,t) == false){
                n++;
            }
            else{
                return n;
            }
        }
    }

    public boolean solve(int n,int t){
        int prod = 1;

        while(n > 0){
            prod *= (n%10);
            n /= 10;
        }

        if(prod % t == 0) return true;

        return false;
    }
}