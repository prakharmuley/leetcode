class Solution {
    public int countTriplets(int[] arr) {
        int ans=0;
        int n=arr.length;
        int xor=0;
        for(int i=0;i<n;i++)
        {
            xor=arr[i];
            for(int j=i+1;j<n;j++)
            {
                xor^=arr[j];
                if(xor==0)
                {
                    ans+=(j-i);
                }
            }
            
        }
        return ans;
    }
}
/*
2 3 1 6 7
2 
2^3 = 1
2^3^1= 0
2^3^1^6 = 6
2^3^1^6^7 =1 



*/