class Solution {
    private void fun(int o, int c, int n, StringBuilder sb, List<String> ans)
    {
        if(2*n==sb.length()&&o==c)
        {
            ans.add(sb.toString());
            return;
        }
        if(o<n){
        sb.append('(');
        fun(o+1,c,n,sb,ans);
        sb.setLength(sb.length()-1);
        }
        
        if(o>c)
        {
         sb.append(')');
         fun(o,c+1,n,sb,ans);
         sb.setLength(sb.length()-1);
        }

    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        fun(0,0,n,new StringBuilder(),ans);
        return ans;
    }
}