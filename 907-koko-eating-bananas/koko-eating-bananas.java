class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canEatAll(piles, h, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canEatAll(int[] piles, int h, int speed) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + speed - 1) / speed; 
            if (time > h) return false;
        }
        return true;
    }

    private int getMax(int[] piles) {
        int max = piles[0];
        for (int pile : piles) {
            if (pile > max) max = pile;
        }
        return max;
    }
}
