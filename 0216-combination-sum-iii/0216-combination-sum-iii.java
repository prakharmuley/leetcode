class Solution {
    private void fun(int i, int k, int n, int[] arr, List<List<Integer>> ans, ArrayList<Integer> list)
    {
        if(k==0&&n==0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i>=n||n<0||k<0) return;
        for(int j=i;j<arr.length;j++)
        {
            list.add(arr[j]);
            fun(j+1,k-1,n-arr[j],arr,ans,list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        int[] arr=new int[9];
        for(int i=0;i<9;i++) arr[i]=i+1;
        fun(0,k,n,arr,ans,new ArrayList<>());
        return ans;
    }
}