
class Solution {
    // private int memo(int[] coins, int amt, int[] dp) {
    //     if (amt == 0) return 0;
    //     if (amt < 0) return -1;
    //     if (dp[amt] != -2) return dp[amt];
        
    //     int minCoins = Integer.MAX_VALUE;
        
    //     for (int coin : coins) {
    //         int res = memo(coins, amt - coin, dp);
    //         if (res != -1) {
    //             minCoins = Math.min(minCoins, 1 + res);
    //         }
    //     }
        
    //     return dp[amt] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
    // }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE-2); 
        dp[0]=0;
        for(int i=1;i<=amount;i++)
        {
            for(int c: coins)
            {
                if(i-c>=0)
                {
                    dp[i]=Math.min(dp[i],1+dp[i-c]);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE-2?-1:dp[amount];
    }
}