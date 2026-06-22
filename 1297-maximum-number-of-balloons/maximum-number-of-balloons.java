class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] ch = new int[26];
        for(int i=0;i<text.length();i++){
            ch[text.charAt(i)-'a']++;
        }  

        int min = Math.min(ch[1],Math.min(ch[0],ch['n'-'a']));
        min = Math.min(min,Math.min(ch['l'-'a']/2,ch['o'-'a']/2));

        return min; 
    }
}