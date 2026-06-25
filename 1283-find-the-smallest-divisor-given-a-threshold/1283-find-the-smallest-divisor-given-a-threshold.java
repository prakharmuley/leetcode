class Solution {
    public int smallestDivisor(int[] arr, int m) {
         int l=1,r=Arrays.stream(arr).max().getAsInt();
         while(l<r)
        {
            int mid=(l+r)/2;
            int ans=0;
            for(int i=0;i<arr.length;i++)
             {
                   ans=ans+(arr[i]/mid)+(arr[i]%mid!=0?1:0);
                  
             }
              
             if(ans<=m)
             {
                r=mid;
             }
             else l=mid+1;

        }
        return l;

    }
}

