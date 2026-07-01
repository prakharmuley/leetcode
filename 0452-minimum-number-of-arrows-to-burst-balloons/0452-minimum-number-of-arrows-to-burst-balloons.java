class Solution {
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int lastEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {

            int st = points[i][0];
            int end = points[i][1];

            if (st > lastEnd) {
                arrows++;
                lastEnd = end;
            }
        }

        return arrows;
    }
}