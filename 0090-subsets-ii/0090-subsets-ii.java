class Solution {
    private void fun(int i, int n, int[] arr, List<List<Integer>> ans, List<Integer> list)
    {
        ans.add(new ArrayList<>(list));
        for(int j=i;j<n;j++)
        {
        if (j > i && arr[j] == arr[j - 1]) continue;
        list.add(arr[j]);
        fun(j+1,n,arr,ans,list);
        list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>  ans=new ArrayList<>();
        Arrays.sort(nums);
        fun(0,nums.length,nums,ans,new ArrayList<>());
        return ans;
    }
}