class Solution {
    public boolean checkValidString(String s) {
        int low=0,high=0;

        for(char ch : s.toCharArray() ){

            if(ch == '('){
                low++;
                high++;
            }
            else if(ch == ')'){
                low=Math.max(low-1,0);
                high--;
            }
            else{
                low=Math.max(low-1,0);
                high++;
            }

            if(high < 0 ) return false;
        }


        return low==0;
    }
}