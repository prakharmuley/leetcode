class Solution {
    private boolean dfs(int[] arr, int i, int k, int part,
                        int target, int sum, boolean[] vis) {

        if (part == k)
            return true;

        for (int j = i; j < arr.length; j++) {

            if (vis[j])
                continue;

            if (arr[j] > sum)
                break;

            
            vis[j] = true;

            if (arr[j] == sum) {
                if (dfs(arr, 0, k, part + 1,
                        target, target, vis))
                    return true;
            } 
            else {
                if (dfs(arr, j + 1, k, part,
                        target, sum - arr[j], vis))
                    return true;
            }

            vis[j] = false;
        }

        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;

        for (int x : nums)
            total += x;

        if (total % k != 0)
            return false;

        int target = total / k;

        Arrays.sort(nums);

        if (nums[nums.length - 1] > target)
            return false;

        boolean[] vis = new boolean[nums.length];

        return dfs(nums, 0, k, 0, target, target, vis);
    }
}