class Solution {
    int ans=0;

    public void dfs(int idx, int n, String[] words, int[] freq,
                    int[] score, int current) {

        ans=Math.max(ans,current);

        for(int i=idx;i<n;i++) {
            String s=words[i];
            int[] mark=new int[26];
            boolean f=true;

            for(int j=0;j<s.length();j++) {
                int x=s.charAt(j)-'a';
                mark[x]++;

                if(mark[x]>freq[x]) {
                    f=false;
                    break;
                }
            }

            if(!f)
                continue;

            for(int j=0;j<s.length();j++) {
                int x=s.charAt(j)-'a';
                freq[x]--;
                current+=score[x];
            }

            dfs(i+1,n,words,freq,score,current);

            for(int j=0;j<s.length();j++) {
                int x=s.charAt(j)-'a';
                freq[x]++;
                current-=score[x];
            }
        }
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq=new int[26];

        for(char c:letters)
            freq[c-'a']++;

        dfs(0,words.length,words,freq,score,0);

        return ans;
    }
}