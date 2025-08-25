class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int top=-1;

        for(int arr: asteroids){
            boolean des=true;
            while(top >=0 && arr <0 && asteroids[top] > 0){
                if(asteroids[top] < -arr){
                    top--;
                    continue;
                }
                else if(asteroids[top] == -arr){
                    top--;
                }
                des=false;
                break;
            }

            if(des){
                asteroids[++top]=arr;
            }
        }

        return Arrays.copyOfRange(asteroids,0,top+1);
    }
}