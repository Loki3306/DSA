class Solution {
    public String sortVowels(String s) {
        String vowels="AEIOUaeiou";
        char[] arr = s.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(char ch : arr){
            if(vowels.indexOf(ch) != -1) sb.append(ch);
        }

        char[] vowelsArray = sb.toString().toCharArray();
        Arrays.sort(vowelsArray);
        int index=0;

        for(int i=0;i<arr.length;i++){
            if(vowels.indexOf(arr[i]) != -1){
                arr[i]=vowelsArray[index++];
            }
        }

        return new String(arr);
    }
}