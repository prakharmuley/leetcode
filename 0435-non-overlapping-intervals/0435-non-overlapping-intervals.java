class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        int ans = 0;
        int lastEnd = Integer.MIN_VALUE;

        for (int[] movie : arr) {
            if (movie[0] >= lastEnd) {
                ans++;
                lastEnd = movie[1];
            }
        }
        return arr.length-ans;
    }
}