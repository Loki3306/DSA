class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int n=s.length();
        int total=0;

        for(int i=0;i<n;i++){
            char currChar=s.charAt(i);
            int currVal= map.get(currChar);

            if(i+1 <n){
                char nextChar= s.charAt(i+1);
                int nextVal= map.get(nextChar);

                if(currVal < nextVal){
                    total-=currVal;
                }
                else{
                    total+=currVal;
                }
            }
            else{
                total+=currVal;
            }
        }

        return total;
    }
}