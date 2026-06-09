class Solution {
    public long beautifulSubarrays(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();

        long count = 0;
        int xor = 0;

        mp.put(xor,1);

        for(int i = 0;i<nums.length;i++){

            xor^=nums[i];

            if(mp.containsKey(xor)){
                count += (long)mp.get(xor);

                mp.put(xor,mp.get(xor)+1);
            }

            else{
                mp.put(xor,1);
            }

            

        }
        
        return count;
    }
}