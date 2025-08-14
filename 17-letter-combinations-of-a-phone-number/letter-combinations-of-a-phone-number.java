class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length()==0) return new ArrayList<>();
        List<String> result=new ArrayList<>();
        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        answer(result,digits,digitToLetters,0,new StringBuilder());
        return result;
    }

    public void answer(List<String> result,String digits, Map<Character, String> digitToLetters, int index, StringBuilder sb){
        if(index == digits.length()){
            result.add(sb.toString());
            return;
        }

        String letters = digitToLetters.get(digits.charAt(index));
        for(char c : letters.toCharArray()){
            sb.append(c);
            answer(result,digits,digitToLetters,index+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}