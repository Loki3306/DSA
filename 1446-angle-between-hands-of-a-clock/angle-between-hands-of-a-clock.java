class Solution {
    public double angleClock(int hour, int minutes) {
        double hHand = hour*(double)(minutes/5);
        double min_angle = minutes * 6;

        double hToMin = (hour*5)%60;
        hToMin += (double)minutes/12;

        double hr_angle = (hToMin ) * 6;

        return Math.min(Math.abs(min_angle-hr_angle),360 - Math.abs(min_angle-hr_angle));
    }
}