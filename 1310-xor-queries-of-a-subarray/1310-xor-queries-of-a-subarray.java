class Solution {
    public int[] xorQueries(int[] a, int[][] q) {
        int pre[]=new int[a.length]; //prefix array
        int res[]=new int[q.length]; //resultant array
        
        pre[0]=a[0];
        
        for(int i=1;i<a.length;i++)
        {
            pre[i]=pre[i-1]^a[i];
        }
        
        for(int i=0;i<q.length;i++)
        {
            if(q[i][0]==0) 
            {
                res[i]=pre[q[i][1]];
            }
            else
            {
                res[i]=pre[q[i][0]-1]^pre[q[i][1]];
            }
        }
        return res;
    }
}