class Solution {
    public int bagOfTokensScore(int[] a, int power) {
        Arrays.sort(a);
        int sc=0;
        int ans=0;
        int n=a.length;
        int j=n-1,i=0;
        while(i<=j)
        {
            if(power>=a[i])
            {
                sc++;
                power-=a[i++];
                ans=Math.max(ans,sc);
            }
            else if(sc>0)
            {
                power+=a[j--];
                sc--;
                
            }
            else break;
           
        }
        return ans;
        
    }
}