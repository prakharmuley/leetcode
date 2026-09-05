class Solution {
    private int power(int b, int p, int m)
    {
        if(p==0) return 1;
        int half=power(b,p/2,m);
        int ans=((half%m)*(half%m))%m;
        if(p%2==0)
        {
            return ans;
        }
        return ((ans%m)*(b%m))%m;
    }
    public int superPow(int a, int[] b) {
        int exp=0;
        a%=1337;
        int ans=1;
        
        for(int i=0;i<b.length;i++) 
        {
            ans=power(ans,10,1337);
            System.out.print("ans1"+"--->"+ans+"\n");
            ans=(ans*power(a,b[i],1337))%1337;
            System.out.print("ans2"+"--->"+ans+"\n");
        }
        return ans;
    }
}
