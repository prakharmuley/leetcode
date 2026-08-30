class Solution {
    private double power(double res, double b, int p)
    {
        if(p==0) return 1;
        double ans=1;
        if(p%2!=0)
        {
            ans=power(res,b*b,p/2);
            ans=ans*b;
        }
        else {
          ans=power(res,b,p/2);
          ans=ans*ans;
        }

          return ans;
    }
    public double myPow(double x, int n) {
        
        double ans=power(1,x,n);
        if(n<0) return 1d/ans;
        return ans;
    
    }
}

//  2^10


// 2^5    2^5


// 2^5 -> 2^2 * 2
// 2^5 -> 2*2 * 2

