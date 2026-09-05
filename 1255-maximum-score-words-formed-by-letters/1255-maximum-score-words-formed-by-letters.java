class Solution {
    int ans=0;
    public void dfs(int idx, int n,String[] words, boolean[] vis, int[] freq, int[] score, int[] a)
    {
         
         ans=Math.max(ans,a[0]);
         for(int i=idx;i<n;i++)
         {
            if(!vis[i])
            {
                boolean f=true;
                String s=words[i];
                int[] mark=new int[26];
                for(int j=0;j<s.length();j++)
                {
                    mark[s.charAt(j)-'a']++;
                    if(mark[s.charAt(j)-'a']>freq[s.charAt(j)-'a'])
                    {
                        f=false;
                        break;
                    }
                                
                }

               

                if(!f)
                {
                    continue;
                }
                 for(int j=0;j<s.length();j++)
                  freq[s.charAt(j)-'a']--;

                vis[i]=true;
                for(int j=0;j<s.length();j++)
                {
                    a[0]+=score[s.charAt(j)-'a'];
                }
                
                
                dfs(i,n,words,vis,freq,score,a);
                 for(int j=0;j<s.length();j++)
                {
                    freq[s.charAt(j)-'a']++;
                    a[0]-=score[s.charAt(j)-'a'];
                }
                vis[i]=false;
            }
         }
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freqq=new int[26];
        for(char c: letters) freqq[c-'a']++;

        for(int i=0;i<words.length;i++)
        {
            boolean[] vis=new boolean[words.length];
            int[] freq=freqq.clone();
            int[] a=new int[1];
            dfs(i,words.length,words,vis,freq,score,a);
            System.out.print(a[0]+ " ---->"+i+"\n");
           // ans=Math.max(ans,a[0]);

        }
        
        return ans;
    }
}