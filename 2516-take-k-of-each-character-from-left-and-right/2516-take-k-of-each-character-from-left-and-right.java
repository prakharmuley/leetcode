class Solution {
    public int takeCharacters(String s, int k) {
        int a=0,b=0,c=0;
        int j=0,i=0;
        int n=s.length();
        for(char ch: s.toCharArray())
        {
            if(ch=='a') a++;
            else if(ch=='b') b++;
            else c++;
        }
        if(a<k||b<k||c<k) return -1;
        a-=k;
        b-=k;
        c-=k;
        int ca=0;
        int cb=0;
        int cc=0;
        int len=0;
        while(j<s.length())
        {
            if(s.charAt(j)=='a') ca++;
            else if(s.charAt(j)=='b') cb++;
            else cc++;
            while(i<n&&(ca>a||cb>b||cc>c))
            {
                if(s.charAt(i)=='a') ca--;
            else if(s.charAt(i)=='b') cb--;
            else cc--;
                i++;
            }
            len=Math.max(len,j-i+1);
             j++;
        }
        return n-len;
    }
}