class Solution {
    public double myPow(double x, int n) {
        long exp=n;
        return power(x,exp);
    }

    public double power(double x,long n){
        if(n==0){
            return 1;
        }

        if(n<0){
            n=-n;
            x=1/x;
        }

        return (n%2==0)? power(x*x,n/2):power(x*x,n/2)*x;
    }
}