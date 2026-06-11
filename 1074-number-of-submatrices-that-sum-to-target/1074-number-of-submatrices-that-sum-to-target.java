class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] pre=new int[n+1][m+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                pre[i][j]=pre[i-1][j]+pre[i][j-1]+matrix[i-1][j-1]-pre[i-1][j-1];
            }
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                Map<Integer,Integer> mp=new HashMap<>();
                mp.put(0,1);
                int sum=0;
                for(int k=0;k<m;k++)
                {
                    sum+=(pre[j+1][k+1]-pre[i][k+1]-pre[j+1][k]+pre[i][k]);
                    ans+=mp.getOrDefault(sum-target,0);
                    mp.put(sum,mp.getOrDefault(sum,0)+1);
                }
            }
        }
        return ans;
    }
}

/*
1 -1
-1 1



*/