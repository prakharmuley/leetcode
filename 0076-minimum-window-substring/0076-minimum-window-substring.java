class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> mp=new HashMap<>();
        for(char c: t.toCharArray()) mp.put(c,mp.getOrDefault(c,0)+1);
        int n=s.length();
        int cnt=0;
        int l=0,r=0,len=Integer.MAX_VALUE;
        int minl=0;
        while(r<n)
        {
            if(mp.containsKey(s.charAt(r)))
            {
                mp.put(s.charAt(r),mp.get(s.charAt(r))-1);
                if(mp.get(s.charAt(r))>=0)
                 {
                           cnt++;
                 }
                while(cnt==t.length())
                {
                    if(r-l+1<len)
                    {
                        minl=l;
                        len=r-l+1;
                    }
                    if(mp.containsKey(s.charAt(l)))
                    {
                        mp.put(s.charAt(l),mp.get(s.charAt(l))+1);
                        if(mp.get(s.charAt(l))>0)
                        {
                            cnt--;
                        }
                    }
                    l++;
                }
            }
            r++;
        }
        return len<=s.length()?s.substring(minl,minl+len):"";
    }
}