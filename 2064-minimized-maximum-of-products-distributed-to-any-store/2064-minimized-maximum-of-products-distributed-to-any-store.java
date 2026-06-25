class Solution {

    public boolean canDistribute(int maxProducts, int n, int[] quantities) {

        int storesNeeded = 0;

        for (int quantity : quantities) {

            storesNeeded += quantity / maxProducts;

            if (quantity % maxProducts != 0) {
                storesNeeded++;
            }
        }

        return storesNeeded <= n;
    }

    public int minimizedMaximum(int n, int[] quantities) {

        int low = 1;

        int high = 0;
        for (int quantity : quantities) {
            high = Math.max(high, quantity);
        }

        int answer = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canDistribute(mid, n, quantities)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }
}