class Solution {
    public int splitArray(int[] arr, int k) {
        if(k>arr.length) return -1;
        int l=Arrays.stream(arr).max().getAsInt(),r=Arrays.stream(arr).sum();
       // System.out.print(r);
        while(l<r)
        {
            int mid=(l+r)/2;
            int sum=0;
            int day=1;
            for(int i=0;i<arr.length;i++)
             {
                   if(sum+arr[i]>mid)
                   {
                  //    System.out.print(i+" "+sum+"-----"+"\n");
                      day++;
                      sum=arr[i];
                   }
                   else
                   {
                    sum+=arr[i];
                   }
                      
             }
            
    
             if(day<=k)
             {
                r=mid;
             }
             else l=mid+1;
            

        }
        return l;
    }
}