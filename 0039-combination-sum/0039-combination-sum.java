class Solution {
    private void fun(int i, int n, int[] arr, int t, List<List<Integer>> ans, List<Integer> list)
    {
        if(t==0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i>=n) return;
        for(int j=i;j<n;j++)
        {
            if(t-arr[j]>=0){
            list.add(arr[j]);
            fun(j,n,arr,t-arr[j],ans,list);
            list.remove(list.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        fun(0,candidates.length,candidates,target,ans,new ArrayList<>());
        return ans;
    }
}