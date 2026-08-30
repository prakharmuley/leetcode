class Solution {
    public void merge(int[] arr, int l, int mid, int r)
    {
        int[] left=new int[mid-l+1];
        int[] right=new int[r-mid];
        for(int i=0;i<left.length;i++) left[i]=arr[l+i];
        for(int i=0;i<right.length;i++) right[i]=arr[mid+i+1];
        int i=0,j=0;
        int k=l;
        while(i<left.length&&j<right.length)
        {
            if(left[i]<right[j])
               arr[k]=left[i++];
            else 
              arr[k]=right[j++];
            
            k++;
        }
         while(i < left.length)
            arr[k++] = left[i++];

        while(j < right.length)
            arr[k++] = right[j++];
     
    }
    private void sort(int[] arr, int l, int r)
    {
        if(l>=r) return;
        int mid=(l+r)/2;
        sort(arr,l,mid);
        sort(arr,mid+1,r);
        merge(arr, l, mid, r);

    }
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        sort(nums,0,n-1);
        return nums;
        
    }
}