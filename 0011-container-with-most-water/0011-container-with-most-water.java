class Solution {
    public int maxArea(int[] h) {
        int mx=0;
        int l=0,r=h.length-1;
        while(l<=r)
        {
            mx=Math.max(mx,Math.min(h[l],h[r])*(r-l));
            if(h[l]<h[r])
            {
                l++;
            }
            else
            {
                r--;
            }
        }
        return mx;
    }
}