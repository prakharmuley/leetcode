class Solution {
    private int res=0;
     private void fun(int i, int n, int[] arr, List<List<Integer>> ans) {
        if (i == n) {
            res++;
            return;
        }

        for (int j = i; j < n; j++) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            if((i+1)%arr[i]==0||arr[i]%(i+1)==0) 
              fun(i + 1, n, arr, ans);

            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public int countArrangement(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=i+1;
        fun(0, n,arr, ans);
        
        return res;

    }
}