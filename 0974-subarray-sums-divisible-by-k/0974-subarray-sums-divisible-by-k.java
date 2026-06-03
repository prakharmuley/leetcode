class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Long,Integer> mp=new HashMap<>();
        mp.put(0*1L,1);
        long sum=0;
        int c=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            sum%=k;
            if(sum<(long)0) {sum+=(long)k;  }
        //     sum%=k;
            if(mp.containsKey(sum))
            {    
                c+=mp.get(sum);
            }
            
            mp.put(sum,mp.getOrDefault(sum,0)+1);
            
        }
        return c;
    }
}