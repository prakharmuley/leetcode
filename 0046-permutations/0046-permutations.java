class Solution {
    private void fun(int i, int n, int[] arr,List<List<Integer>> ans, List<Integer> list, Set<Integer> hs)
    {
        if(list.size()==n)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int j=0;j<n;j++)
        {
            if(!hs.contains(arr[j])){
            hs.add(arr[j]);
            list.add(arr[j]);
            fun(i+1,n,arr,ans,list,hs);
            list.remove(list.size()-1);
            hs.remove(arr[j]);
            }
            
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        fun(0,nums.length,nums,ans,new ArrayList<>(), new HashSet<>());
        return ans;
    }
}