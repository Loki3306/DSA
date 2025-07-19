class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        boolean exists = true;

        while (exists) {
            exists = false;
            List<List<Integer>> list = new ArrayList<>();

            int i = 0;
            while (i < intervals.length) {
                if (i < intervals.length - 1 && intervals[i][1] >= intervals[i + 1][0]) {
                    int start = intervals[i][0];
                    int end = Math.max(intervals[i][1], intervals[i + 1][1]);
                    list.add(Arrays.asList(start, end));
                    exists = true;
                    i += 2; // skip next since it's merged
                } else {
                    list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
                    i++;
                }
            }

            // Convert list back to intervals for next round
            int[][] newIntervals = new int[list.size()][2];
            for (int j = 0; j < list.size(); j++) {
                newIntervals[j][0] = list.get(j).get(0);
                newIntervals[j][1] = list.get(j).get(1);
            }
            intervals = newIntervals;
        }

        return intervals;
    }
}
