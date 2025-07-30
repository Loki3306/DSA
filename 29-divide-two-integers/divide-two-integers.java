class Solution {
    public int divide(int dividend, int divisor) {
        // Handle special case: Integer.MIN_VALUE / -1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Work with positive long values to avoid overflow for Math.abs(Integer.MIN_VALUE)
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int quotient = 0;

        // Iterate while the absolute dividend is greater than or equal to the absolute divisor
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            int multiple = 1;
            // Find the largest multiple of absDivisor that is less than or equal to absDividend
            // using left shifts (doubling tempDivisor and multiple)
            while (absDividend >= (tempDivisor << 1) && (tempDivisor << 1) > 0) { // (tempDivisor << 1) > 0 check for overflow
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            // Subtract the largest found multiple from absDividend
            absDividend -= tempDivisor;
            // Add the corresponding multiple to the quotient
            quotient += multiple;
        }

        // Apply the sign
        return isNegative ? -quotient : quotient;
    }
}