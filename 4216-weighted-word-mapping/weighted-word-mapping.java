class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        char[] ch = new char[26];
        for(int i=0;i<26;i++){
            ch[i] = (char)('z' - i);
        }   

        StringBuilder sb = new StringBuilder();
        int n = words.length;

        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<words[i].length();j++){
                cnt += weights[words[i].charAt(j) - 'a'];
            }
            sb.append(ch[cnt%26]);
        }

        return sb.toString();
    }
}