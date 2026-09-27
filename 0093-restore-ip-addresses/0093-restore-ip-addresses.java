class Solution {
    private void fun(int i, List<String> list, String s, StringBuilder sb)
    {
        if(i>=s.length())
        {
            String[] arr=sb.toString().split("\\.");
            if(arr.length==4){
             list.add(sb.toString().substring(0,sb.length()-1));
            }

            return;
        }
        for(int j=i+1;j<=s.length();j++)
        {
            if(j-i<=3){
            int num=Integer.parseInt(s.substring(i,j));
            if(num>=0&&num<256&&(s.charAt(i)!='0'||j-i==1))
            {
                int l=sb.length();
                sb.append(num);
                sb.append('.');
                fun(j,list,s,sb);
                sb.setLength(l);
            }
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> ans=new ArrayList<>();
        if(s.length()==0)
        {
            return ans;
        }
        StringBuilder sb=new StringBuilder();
        fun(0,ans,s,sb);
        return ans;
    }
}