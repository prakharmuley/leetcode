class Solution {
    public void dfs(int[] arr, int st, int end)
    {
        if(st>=end) return;

        int[] temp=new int[end-st+1];
        int idx=0;

        for(int i=st;i<=end;i+=2) 
        {
             temp[idx++]=arr[i];
        }
         for(int i=st+1;i<=end;i+=2) 
        {
             temp[idx++]=arr[i];
        }
        for(int i=st;i<=end;i++) arr[i]=temp[i-st];
        int mid=(st+end)/2;
        dfs(arr,st,mid);
        dfs(arr,mid+1,end);
        

    }
    public int[] beautifulArray(int n) {
       int[] ans=new int[n];
       for(int i=0;i<n;i++) ans[i]=(i+1);
       dfs(ans,0,n-1) ;
       return ans;
    }
}