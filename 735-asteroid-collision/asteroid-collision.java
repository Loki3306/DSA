class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for (int a : arr) {
            boolean alive = true;
            while (alive && !st.isEmpty() && st.peek() > 0 && a < 0) {
                if (st.peek() < -a) {
                    st.pop(); 
                } else if (st.peek() == -a) {
                    st.pop(); 
                    alive = false;
                } else {
                    alive = false; 
                }
            }
            if (alive) st.push(a);
        }

        int[] ans = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}
