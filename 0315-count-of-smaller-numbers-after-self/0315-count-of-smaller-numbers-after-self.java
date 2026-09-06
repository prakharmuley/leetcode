class Solution {
    int[] idx;
    Pair[] pair;
    private void merge(int[] arr, int l, int mid, int r, List<Integer> ans)
    {
        Pair[] temp1=new Pair[mid-l+1];
        Pair[] temp2=new Pair[r-mid];
        int i1=0;
        int i2=0;
        for(int i=l;i<=mid;i++) temp1[i1++]=pair[i];
        for(int i=mid+1;i<=r;i++) temp2[i2++]=pair[i];
        i1=0;
        i2=0;
        int i=l;
        int cnt=0;
        while(i1<temp1.length&&i2<temp2.length)
        {
              if(temp1[i1].f>temp2[i2].f)
              {
                cnt++;
                pair[i]=temp2[i2];
                i2++;
                i++;
              }
              else
              {
                ans.set(temp1[i1].s,cnt+ans.get(temp1[i1].s));
                pair[i]=temp1[i1];
                i++;
                i1++;
              }
        } 
        while(i1<temp1.length) {pair[i++]=temp1[i1]; ans.set(temp1[i1].s,ans.get(temp1[i1].s)+cnt); i1++;}
        while(i2<temp2.length) pair[i++]=temp2[i2++];
       

    }
    private void fun(int[] arr, int st, int end, List<Integer> ans)
    {
        if(st>=end) return;
        int mid=(st+end)/2;
        fun(arr,st,mid,ans);
        fun(arr,mid+1,end,ans);
        merge(arr,st,mid,end,ans);
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans=new ArrayList<>(nums.length);
        
        int n=nums.length;
        pair=new Pair[n];
        for(int i=0;i<n;i++)
        {
            pair[i]=new Pair(nums[i],i);
            ans.add(0);
        }
        this.idx=new int[n];
        this.idx= Arrays.copyOf(nums, nums.length);
         fun(nums,0,n-1,ans);
         return ans;
    }
}
class Pair{
    int f;
    int s;
    public Pair(int f, int s)
    {
        this.f=f;
        this.s=s;
    }
}