class Solution {
    public String sortVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] arr = s.toCharArray();
        StringBuilder temp = new StringBuilder();
        for (char c : arr) {
            if (vowels.indexOf(c) != -1) temp.append(c);
        }
        char[] v = temp.toString().toCharArray();
        java.util.Arrays.sort(v);
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (vowels.indexOf(arr[i]) != -1) {
                arr[i] = v[idx++];
            }
        }
        return new String(arr);
    }
}
