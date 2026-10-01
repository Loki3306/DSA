class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int idx = 0;
        while(idx < n && citations[idx] < n-idx) idx++;
        return n-idx;
    }
}