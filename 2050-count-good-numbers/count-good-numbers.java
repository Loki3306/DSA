class Solution {

    public static long Modulo=1000000007;

    public int countGoodNumbers(long n) {
        long evenPos=(n+1)/2;
        long oddPos=n/2;

        long evenWays=power(5,evenPos);
        long oddWays=power(4,oddPos);

        return (int)((evenWays*oddWays)%Modulo);
    }

    public long power(int x,long n){
        if(n==0) return 1;
        long half= power(x,n/2);
        long result=(half*half)%Modulo;
          if (n % 2 == 1) result = (result * x) % Modulo;
        return result;
    }
}