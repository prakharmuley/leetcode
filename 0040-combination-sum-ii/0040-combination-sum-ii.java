class Solution {
    private void fun(int i, List<List<Integer>> ans, int[] arr, int tar, List<Integer> list)
    {
        if(tar==0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(tar<0||i>=arr.length) return;

        for(int j=i;j<arr.length;j++)
        {
            if(j>i&&arr[j]==arr[j-1])
            {
                continue;
            }
            if (arr[j] > tar) break;
            list.add(arr[j]);
            fun(j+1,ans,arr,tar-arr[j],list);
            list.remove(list.size()-1);
        }

        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        fun(0,ans,candidates,target,new ArrayList<>());
        return ans;
    }
}