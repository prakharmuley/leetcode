import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> freq = new HashMap<>();
        long ans = 0;
        long pairs = 0;

        int left = 0;

        for (int right = 0; right < n; right++) {

            pairs += freq.getOrDefault(nums[right], 0);
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            while (pairs >= k) {
                ans += (n - right);

                pairs -= freq.get(nums[left]) - 1;
                freq.put(nums[left], freq.get(nums[left]) - 1);

                left++;
            }
        }

        return ans;
    }
}