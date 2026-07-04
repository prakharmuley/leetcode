class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> al=new ArrayList<>();
        int h[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            h[s.charAt(i)-'a']=i;
        }
        int l=0;
        int r=0;
        for(int i=0;i<s.length();i++)
        {
            l=Math.max(l,h[s.charAt(i)-'a']);
            if(l==i)
            {
             al.add(l-r+1);
             r=l+1;   
            }
        }
        return al;
    }
}