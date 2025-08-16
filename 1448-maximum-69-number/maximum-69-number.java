class Solution {
    public int maximum69Number (int num) {
        String number= String.valueOf(num);
        int index=0;
        while(index < number.length() && number.charAt(index)=='9') index++;
        if(index == number.length()) return num;

        number = number.substring(0, index) + '9' + number.substring(index + 1);
    
        return Integer.parseInt(number);
    }
}