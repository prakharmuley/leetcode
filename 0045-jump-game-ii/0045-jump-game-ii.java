class Solution {
    public int jump(int[] nums) {
       int farthest = 0;
       int n=nums.length;
       int currentEnd = 0;
       int jumps = 0;

       for (int i = 0; i < n - 1; i++) {
       farthest = Math.max(farthest, i + nums[i]);

        if (i == currentEnd) {
         jumps++;
         currentEnd = farthest;
        }
       }
       return jumps;
    }
}
/*
jump=1
ans=1

jump=3
ans=2

jump


*/