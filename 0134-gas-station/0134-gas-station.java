class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int idx=0;
        int tot=0;
        int fuel=0;
        int n=cost.length;
        for(int i=0;i<n;i++)
        {
            tot+=(gas[i]-cost[i]);
            fuel+=(gas[i]-cost[i]);
            if(fuel<0)
            {
                fuel=0;
                idx=i+1;
            }
        }
        return tot<0?-1:idx;
    }
}


//1-3+2 +  2-4+3   + 4-1+5  