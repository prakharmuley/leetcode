class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        boolean[] vis = new boolean[n];
        vis[start] = true;

        while (!q.isEmpty()) {
            int ind = q.poll();

            if (arr[ind] == 0) {
                return true;
            }

            int nextInd1 = ind + arr[ind];
            if (nextInd1 < n && !vis[nextInd1]) {
                q.offer(nextInd1);
                vis[nextInd1] = true;
            }

            int nextInd2 = ind - arr[ind];
            if (nextInd2 >= 0 && !vis[nextInd2]) {
                q.offer(nextInd2);
                vis[nextInd2] = true;
            }
        }

        return false;
    }
}