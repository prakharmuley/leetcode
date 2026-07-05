class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] arr=new int[n];
        int[] brr=new int[n];
        Arrays.fill(arr,1);
        Arrays.fill(brr,1);
        for(int i=1;i<n;i++)
        {
            if(ratings[i-1]<ratings[i])
            {
                arr[i]=arr[i-1]+1;
            }
            else if(ratings[i-1]>ratings[i])
            {
                if(arr[i-1]>arr[i]) continue;

                arr[i-1]=Math.max(arr[i-1],arr[i])+1;
            }
            
        }
        for(int i=n-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1])
            {
                brr[i]=brr[i+1]+1;
            }
            else if(ratings[i]<ratings[i+1])
            {
                if(brr[i]<brr[i+1]) continue;

                brr[i+1]=Math.max(brr[i],brr[i+1])+1;
            }
            
        }
        
        
        int ans=0;
        int sum1=0;
        int sum2=0;
        for(int i=0;i<n;i++)
        {
            ans+=Math.max(arr[i],brr[i]);
        }
        return ans;
    }
}
