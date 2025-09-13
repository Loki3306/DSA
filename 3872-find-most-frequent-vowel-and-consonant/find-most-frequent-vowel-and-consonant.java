class Solution {
    public int maxFreqSum(String s) {
        int[] count=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            count[ch-'a']++;
        }

        int vowelMax=0;
        int constMax=0;

        for(int i=0;i<26;i++){
            if(i==0 || i==4 || i==8 || i==14 || i==20){
                vowelMax=Math.max(vowelMax,count[i]);
            }else{
                constMax=Math.max(constMax,count[i]);
            }
        }

        return constMax+vowelMax;
    }
}