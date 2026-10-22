class Solution {

    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        if(n<=2) return n;
        int prev1=1;
        int prev2=2;
        int nxt=2;
        for(int i=2;i<=n;i++)
        {
           int temp=nxt;
           nxt=prev1+prev2;
           prev2=nxt;
           prev1=temp;

        }
        
        return prev1;
    }
}