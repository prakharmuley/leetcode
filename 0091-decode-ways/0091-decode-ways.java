class Solution {
    // private int solve(int i, String s, int[] dp)
    // {
    //     if(i>=s.length()) return 1;
    //     if(s.charAt(i)=='0') return 0;
    //     if(dp[i]!=-1) return dp[i];
    //     int ways=solve(i+1,s,dp);
    //     if(i+1<s.length())
    //     {
    //         int num=((s.charAt(i)-'0')*10)+(s.charAt(i+1)-'0');
    //         if(num>=10&&num<=26) 
    //         {
    //             ways+=solve(i+2,s,dp);
    //         }
    //     }
    //     return dp[i]=ways;
    // }
    public int numDecodings(String s) {
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=s.charAt(0)=='0'?0:1;
        for(int i=2;i<=s.length();i++)
        {
            int tens=(s.charAt(i-2)-'0')*10;
            int unit=(s.charAt(i-1)-'0');
            if(unit>=1&&unit<10)
            {
                dp[i]+=dp[i-1];
            }
            if(unit+tens<=26&&unit+tens>=10)
            {
                dp[i]+=dp[i-2];
            }
            
        }
        return dp[s.length()];
    }
}