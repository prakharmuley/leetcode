class Solution {
    public int maximumUnits(int[][] arr, int truckSize) {

        Arrays.sort(arr, (a, b) -> b[1] - a[1]);

        int ans = 0;

        for (int[] box : arr) {

            int take = Math.min(box[0], truckSize);

            ans += take * box[1];

            truckSize -= take;

            if (truckSize == 0)
                break;
        }

        return ans;
    }
}