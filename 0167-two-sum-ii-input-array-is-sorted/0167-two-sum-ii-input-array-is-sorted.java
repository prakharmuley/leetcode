class Solution {
    public int[] twoSum(int[] arr, int target) {
        int l=0,r=arr.length-1;
        while(l<r)
        {
            if(arr[l]+arr[r]==target)
            {
                return new int[]{l+1,r+1};
            }
            if(arr[l]+arr[r]>target) r--;
            else l++;
        }
        return new int[]{l,r};
    }
}