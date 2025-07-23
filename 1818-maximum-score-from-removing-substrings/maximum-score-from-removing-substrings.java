class Solution {
    public int maximumGain(String s, int x, int y) {
        char firstChar, secondChar;
        int firstScore, secondScore;

       
        if (x > y) {
            firstChar = 'a'; secondChar = 'b'; firstScore = x;
            secondChar = 'b'; secondScore = y;
        } else {
            firstChar = 'b'; secondChar = 'a'; firstScore = y;
            secondChar = 'a'; secondScore = x;
        }

        int total = 0;
        Stack<Character> stack = new Stack<>();

   
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == firstChar && c == secondChar) {
                stack.pop();
                total += firstScore;
            } else {
                stack.push(c);
            }
        }

       
        Stack<Character> temp = new Stack<>();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (!temp.isEmpty() && c == secondChar && temp.peek() == firstChar) {
                temp.pop();
                total += secondScore;
            } else {
                temp.push(c);
            }
        }

        return total;
    }
}
