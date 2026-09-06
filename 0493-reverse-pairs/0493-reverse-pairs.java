class Solution {
    private void merge(int l, int m, int r, int[] arr, int[] a)
    {
        long[] temp1=new long[m-l+1];
        long[] temp2=new long[r-m];
        int i1=0,i2=0;
       
        for(int k=l;k<=m;k++) temp1[i1++]=arr[k]*1L;
        for(int k=m+1;k<=r;k++) temp2[i2++]=arr[k]*1L;
        int cnt=0;


        i1=0;
        i2=0;
        while(i1<temp1.length&&i2<temp2.length)
        {
            if(temp1[i1]>2*temp2[i2])
            {
                a[0]+=(temp1.length-i1);
                i2++;
            }
            else
            {
                i1++;
            }
        }

        

        i1=0;
        i2=0;
        int i=l;
        while(i1<temp1.length&&i2<temp2.length)
        {
            if(temp1[i1]>temp2[i2])
            {
                arr[i]=(int)temp2[i2];
                i++;
                i2++;
            }
            else
            {
                arr[i]=(int)temp1[i1];
                i++;
                i1++;
            }
        }

        while(i1<temp1.length)
        {
            arr[i]=(int)temp1[i1];
            i1++;
            i++;
        }

        while(i2<temp2.length)
        {
            arr[i]=(int)temp2[i2];
            i2++;
            i++;
        }
    }
    private void fun(int l, int r, int[] arr, int[] ans)
    {
        if(l>=r) return;
        int mid=(l+r)/2;
        fun(l,mid,arr,ans);
        fun(mid+1,r,arr,ans);
        merge(l,mid,r,arr,ans);
    }
    public int reversePairs(int[] nums) {
        int[] a=new int[1];
        fun(0,nums.length-1,nums,a);
        return a[0];

    }
}