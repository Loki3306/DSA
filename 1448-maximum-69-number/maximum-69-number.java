class Solution {
    public int maximum69Number (int num) {
        StringBuilder sb=new StringBuilder(String.valueOf(num));
        int index=0;
        while(index < sb.length() && sb.charAt(index) == '9'){
            index++;
        }
        if(index == sb.length()) return num;

        sb.replace(index,index+1,"9");
        return Integer.parseInt(sb.toString());
    }
}