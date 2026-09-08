class Solution {
    Pair[] pair;
    long lower, upper;
    int ans = 0;

    private void merge(long[] arr, int l, int mid, int r) {
        int j = mid + 1;
        int k = mid + 1;

        for (int i = l; i <= mid; i++) {
            while (j <= r && pair[j].f - pair[i].f < lower)
                j++;

            while (k <= r && pair[k].f - pair[i].f <= upper)
                k++;

            ans += k - j;
        }

        Pair[] temp1 = new Pair[mid - l + 1];
        Pair[] temp2 = new Pair[r - mid];

        int i1 = 0;
        int i2 = 0;

        for (int i = l; i <= mid; i++)
            temp1[i1++] = pair[i];

        for (int i = mid + 1; i <= r; i++)
            temp2[i2++] = pair[i];

        i1 = 0;
        i2 = 0;
        int i = l;

        while (i1 < temp1.length && i2 < temp2.length) {
            if (temp1[i1].f > temp2[i2].f)
                pair[i++] = temp2[i2++];
            else
                pair[i++] = temp1[i1++];
        }

        while (i1 < temp1.length)
            pair[i++] = temp1[i1++];

        while (i2 < temp2.length)
            pair[i++] = temp2[i2++];
    }

    private void fun(long[] arr, int st, int end) {
        if (st >= end)
            return;

        int mid = (st + end) / 2;

        fun(arr, st, mid);
        fun(arr, mid + 1, end);

        merge(arr, st, mid, end);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;

        this.lower = lower;
        this.upper = upper;
        this.ans = 0;

        pair = new Pair[n + 1];

        long sum = 0;
        pair[0] = new Pair(0, 0);

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            pair[i + 1] = new Pair(sum, i + 1);
        }

        fun(new long[n + 1], 0, n);

        return ans;
    }
}

class Pair {
    long f;
    int s;

    public Pair(long f, int s) {
        this.f = f;
        this.s = s;
    }
}