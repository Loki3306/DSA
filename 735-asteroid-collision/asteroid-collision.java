class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int top=-1;

        for(int a:asteroids){
            boolean destroyed=false;

            while(top >=0 && asteroids[top] > 0 && a<0){
                if(asteroids[top] < -a){
                    top--;
                    continue;
                }else if(asteroids[top] == -a){
                    top--;
                }
                destroyed=true;
                break;
            }

            if(!destroyed){
                asteroids[++top]=a;
            }
        }

        return Arrays.copyOfRange(asteroids,0,top+1);
    }
}