class Solution {
    public List<Integer> diffWaysToCompute(String str) {
            Map<String,List<Integer>> mp=new HashMap<>();

        if(mp.containsKey(str))
        {
            return mp.get(str);
        }
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<str.length();i++){ 
          if(str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*') {
           List<Integer> l1=diffWaysToCompute(str.substring(0,i));
           List<Integer> l2=diffWaysToCompute(str.substring(i+1));
           for(int x: l1)
            {
             for(int y: l2)
             {
               int ans=0;

                if(str.charAt(i)=='+')
                {
                      ans=x+y;
                      l.add(ans);

                }
                else if(str.charAt(i)=='-')
                {
                    ans=x-y;
                    l.add(ans);

                }
                else if(str.charAt(i)=='*')
                {
                    ans=x*y;
                    l.add(ans);
                }
             }       
         }
       
        }
         
        
        }
        if(l.isEmpty())
        {
            l.add(Integer.valueOf(str));
        }
         mp.put(str,l); 
        return l;

        

    }
}