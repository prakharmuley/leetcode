class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character,Integer> mp=new HashMap<>();
        Map<Character,Integer> mpp=new HashMap<>();
        for(char c: s.toCharArray()) mp.put(c,mp.getOrDefault(c,0)+1);
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)-1);
            while(!st.isEmpty()&&mp.getOrDefault(st.peek(),0)>0&&st.peek()>s.charAt(i)&&!mpp.containsKey(s.charAt(i)))
            {
                mpp.put(st.peek(),mpp.getOrDefault(st.peek(),0)-1);  
                if(mpp.getOrDefault(st.peek(),0)<=0) mpp.remove(st.peek());      
                st.pop();
            }
             if(!mpp.containsKey(s.charAt(i))){
                st.push(s.charAt(i));
               mpp.put(s.charAt(i),mpp.getOrDefault(s.charAt(i),0)+1); //ad
             }
        }
       
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        return sb.reverse().toString();


    }
}