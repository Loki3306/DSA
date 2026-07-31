class Solution {
    public int minimumPushes(String word) {
        int cnt;
        List<Integer> freq = new ArrayList<>();
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        int len = word.length();

        int curr = chars[len-1];
        cnt = 1;
        for(int i=len-2;i>=0;i--){
            if(chars[i] != curr){
                freq.add(cnt);
                cnt = 0;
                curr = chars[i];
            }

            cnt++;
        }
        freq.add(cnt);

        freq.sort(Comparator.reverseOrder());



        int mult = 1;
        cnt = 0;
        int ind = 0;
        int ans = 0;
        while(ind < freq.size()){
            ans += (mult*freq.get(ind) ) ;
            cnt++;

            if(cnt == 8){
                cnt = 0;
                mult++;
            }

            ind++;
        }
        

        return ans;
    }
}