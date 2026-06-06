class Solution {
    public int findMaxLength(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0) nums[i]=-1;
        }
        int ans=0;
        Map<Integer,Integer> mp=new HashMap<>();

        mp.put(0,-1);
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(mp.containsKey(sum))
            {
                ans=Math.max(ans,i-mp.get(sum));
            }
            if(!mp.containsKey(sum))
             mp.put(sum,i);
        }
        return ans;
    }
}