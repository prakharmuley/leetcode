// class Solution {
//     public int bs(int[] a, int i, int key, boolean f)
//     {
//         int l=i+1,r=a.length;
//         int ans=-1;
//         if(f){
//         while(l<r)
//         {
//             int mid=l+((r-l)/2);
//             if(a[mid]>key)
//             {
//                r=mid;
//             }
//             else l=mid+1;
//         }
//             return l;
//         }
//         else
//         {
//             while(l<r)
//         {
//             int mid=l+((r-l)/2);
//             if(a[mid]<key)
//             {
//                l=mid+1;
//             }
//             else r=mid;
//         }
//             return l;
//         }
        
//     }
//     public long countFairPairs(int[] nums, int lower, int upper) {
//         Map<Integer,Integer> mp=new HashMap<>();
//         int n=nums.length;
//         Arrays.sort(nums);
//         long ans=0L;
//         for(int i=0;i<n;i++)
//         {
//             long u=(long)bs(nums,i,upper-nums[i],true);
//            // System.out.print(u+"u+\n");
//             long l=(long)bs(nums,i,lower-nums[i],false);
//             ans+=(u-l);
//           //  System.out.print(l+"l+\n");
//         }
//         return ans;
//     }
// }



class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countPairs(nums, upper) - countPairs(nums, lower - 1);
    }

    private long countPairs(int[] nums, int target) {
        long count = 0;
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            if (nums[left] + nums[right] > target) right--;
            else {
                count += right - left;
                left++;
            }
        }
        return count;
    }
}