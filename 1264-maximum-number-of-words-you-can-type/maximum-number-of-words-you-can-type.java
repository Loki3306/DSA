class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words=text.split(" ");
        int[] chars=new int[26];
        for(int i=0;i<brokenLetters.length();i++){
            char ch=brokenLetters.charAt(i);

            chars[ch-'a']++;
        }

        int count=0;
        for(int i=0;i<words.length;i++){
            if(exists(words[i],chars)) count++;
        }

        return count;
    }

    public boolean exists(String word,int[] chars){
        for(int i=0;i<word.length();i++){
           char ch=word.charAt(i);

           if(chars[ch-'a'] != 0) return false;
        }

        return true;
    }
}