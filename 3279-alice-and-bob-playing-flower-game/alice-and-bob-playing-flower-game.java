class Solution {
    public long flowerGame(int n, int m) {
        return (long)( (long)( (long)((n+1)/2) * (long)(m/2) )+ (long)( (long)(n/2)* (long)( (m+1)/2 ) ) );
    }
}