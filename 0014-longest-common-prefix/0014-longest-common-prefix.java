class Solution {
    public String longestCommonPrefix(String[] s) {
        
        Arrays.sort(s);
        
        String st=new String();
        if(s!=null&&s.length>0)
        {
            char a[]=s[0].toCharArray();
            char b[]=s[s.length-1].toCharArray();
            for(int i=0;i<a.length;i++)
            {
                if(i<b.length&&a[i]==b[i])
                    st+=a[i];
                else
                {
                    return st;
                }
            }
        }
       
        return st;
        
    }
}