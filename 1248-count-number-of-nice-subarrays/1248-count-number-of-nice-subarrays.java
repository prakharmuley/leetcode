class Solution {
      public int fun(int[] arr, int k)
    {
        int i=0,j=0;
        int n=arr.length;
        int ans=0;
        Map<Integer,Integer> mp=new HashMap<>();
        while(j<n)
        {
              mp.put(arr[j]%2,mp.getOrDefault(arr[j]%2,0)+1);
              while(mp.getOrDefault(1,0)>k)
              {
                mp.put(arr[i]%2,mp.get(arr[i]%2)-1);
                if(mp.get(arr[i]%2)==0)
                {
                    mp.remove(arr[i]%2);
                }
                i++;
              }
             
              ans+=(j-i+1);
               j++;
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
         return fun(nums,k)-fun(nums,k-1);
    }
}