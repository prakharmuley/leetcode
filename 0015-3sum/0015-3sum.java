class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>  ans=new ArrayList<>();
        
        int n=nums.length;
        Arrays.sort(nums);
        int i=0,j=1,k=n-1;
        while(i<n-1)
        {
            j=i+1;
            k=n-1;
            if (i > 0 && nums[i] == nums[i - 1]) {  
                i++;
                continue;
            }
           
            while(j<k)
            {
                
                 List<Integer> list=new ArrayList<>();
                if(nums[i]+nums[j]+nums[k]==0)
                {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
                else if(nums[i]+nums[j]+nums[k]>0)
                {
                    k--;
                }
                else j++;
            }
            i++;

        }
        return ans;
    }
}