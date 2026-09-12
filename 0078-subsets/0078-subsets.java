class Solution {
    private void fun(int i, int n,int[] a, List<List<Integer>> arr,List<Integer> list )
    {     
        arr.add(new ArrayList(list));
        for(int j=i;j<n;j++){
        list.add(a[j]);
        fun(j+1,n,a,arr,list);
        list.remove(list.size()-1);
        }
    } 
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        fun(0,nums.length,nums, ans, new ArrayList<>());
        return ans;
    }
}