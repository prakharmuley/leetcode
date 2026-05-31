class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long res = 0;
        int max = Integer.MIN_VALUE;

        int left = 0;
        int curr = 0;
        for(int i=0; i<n; i++) if(nums[i] > max) max = nums[i];

        for(int right=0; right<n; right++){
            curr += (nums[right] == max) ? 1: 0;
            while(curr == k){
                curr -= (nums[left] == max) ? 1: 0;
                left++;
                res += n - right;
            }
        }
        return res;
    }
}