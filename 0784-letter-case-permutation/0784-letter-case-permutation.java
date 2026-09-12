class Solution {
    private void fun(int i, int n, List<String> ans, char[] arr)
    {
        
        for(int j=i;j<n;j++)
        {
            if(arr[j]>='0'&&arr[j]<='9') continue;
            char temp=arr[j];
            if(Character.isLowerCase(arr[j]))
            {
                arr[j]=Character.toUpperCase(arr[j]);
                ans.add(new String(arr));
                fun(j+1,n,ans,arr);
                arr[j]=temp;        
            }
            else
            {
                arr[j]=Character.toLowerCase(arr[j]);
                ans.add(new String(arr));
                fun(j+1,n,ans,arr);
                arr[j]=temp; 
            }
        }

    }
    public List<String> letterCasePermutation(String s) {
        List<String> ans=new ArrayList<>();
        ans.add(s);
        fun(0,s.length(),ans,s.toCharArray());
        return ans;
    }
}