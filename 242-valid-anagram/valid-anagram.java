class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            map.put(cs,map.getOrDefault(cs,0) + 1 );
            map.put(ct,map.getOrDefault(ct,0) - 1);
        }

        for(int count : map.values()){
            if(count != 0 ) return false;
        }

        return true;
    }
}