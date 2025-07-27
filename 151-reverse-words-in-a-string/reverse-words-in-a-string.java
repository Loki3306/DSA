class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        s=s.trim();
        int startIndex=s.length() -1;
        int endIndex=s.length();
        
        
        for(int i=startIndex;i>=0;i--){
            if(s.charAt(i) == ' '){
                if(!s.substring(i+1, endIndex).equals(" ") && i + 1 < endIndex){
                    sb.append(s.substring((i+1),endIndex));
                    sb.append(" ");
                }
                endIndex=i;
            }
        }
        if (!s.substring(0, endIndex).isBlank())
        sb.append(s.substring(0, endIndex));

        return sb.toString();
    }
}