class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        int temp = sum;
        while(sb.length() < num){
            int dig = sum % 9;

            if(sum < 9){
                sb.append(dig);
                sum -= dig;
            }
            else{
                sb.append(9);
                sum -= 9;
            }
        }
        
        for(int i=0;i<sb.length();i++){
            char ch = sb.charAt(i);
            int dig = ch - '0';
            temp -= dig;
        }

        if(temp != 0 ) return "";
        return sb.toString();
    }
}