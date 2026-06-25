class Solution {
    public int numRescueBoats(int[] a, int limit) {
        Arrays.sort(a);
        int cnt=0;
       int l=0,r=a.length-1;
        while(l<=r)
        {
            if(a[l]+a[r]<=limit) { l++; r--;}
            else {
              r--;   
            }
            cnt++;
        }
        return cnt;
        
    }
}