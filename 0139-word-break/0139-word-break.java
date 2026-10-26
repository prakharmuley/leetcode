// class Solution {
//     private boolean dfs(int i, int n, StringBuilder sb, String s, List<String> list, Map<String, Boolean> memo) {
//         String currentStr = sb.toString();
//         if (currentStr.equals(s)) return true;
//         if (sb.length() > s.length()) return false;
//         if (memo.containsKey(currentStr)) return memo.get(currentStr);

//         for (String str : list) {
//             String current = currentStr + str;
//             if (s.startsWith(current)) {
//                 sb.append(str);
//                 if (dfs(i, n, sb, s, list, memo)) {
//                     memo.put(currentStr, true);
//                     return true;
//                 }
//                 sb.setLength(sb.length() - str.length()); 
//             }
//         }
        
//         memo.put(currentStr, false);
//         return false;
//     }

//     public boolean wordBreak(String s, List<String> wordDict) {
//         return dfs(0, s.length(), new StringBuilder(), s, wordDict, new HashMap<>());
//     }
// }
class Solution {
    // private boolean dfs(int i, int n, String s, List<String> list, Boolean[] memo) {
    //     if (i == n) return true;
    //     if (memo[i] != null) return memo[i];

    //     for (String str : list) {
    //         int len = str.length();
    //         if (i + len <= n && s.startsWith(str, i)) {
    //             if (dfs(i + len, n, s, list, memo)) {
    //                 return memo[i] = true;
    //             }
    //         }
    //     }
        
    //     return memo[i] = false;
    // }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++)
        {
            for(String str: wordDict)
            {
               if(i>=str.length()&&dp[i-str.length()]&&s.startsWith(str,i-str.length()))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
            
            
    
       return dp[n];
       // return dfs(0, n, s, wordDict, new Boolean[n]);
    }
}