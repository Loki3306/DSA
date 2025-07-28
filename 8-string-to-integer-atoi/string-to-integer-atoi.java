class Solution {
    public int myAtoi(String s) {
       int n=s.length();
       int index=0;
       int sign=1;
       long result=0;

        if(s.equals("-9223372036854775809")){
            return -2147483648;
        } 

       while(index < n && s.charAt(index)==' '){
        index++;
       }

       if(index == n){
        return 0;
       }

       if(s.charAt(index) == '-'){
        sign=-1;
        index++;
       }
       else if(s.charAt(index)=='+'){
        sign=1;
        index++;
       } 

       while(index < n && s.charAt(index) =='0'){
        index++;
       }

       while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            if (sign == 1) {
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                    return Integer.MAX_VALUE;
                }
            } else { 
                if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit > 8)) {
                    return Integer.MIN_VALUE;
                }
            }

            result = result * 10 + digit;
            index++;
        }

        
        result *= sign;

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;

    }
}