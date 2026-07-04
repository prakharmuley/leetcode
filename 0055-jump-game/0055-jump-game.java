class Solution {
    public boolean canJump(int[] nums) {
        int j=0,jump=0;
        int n=nums.length;
        while(j<n)
        {
            System.out.print(jump+"\n");
            if(jump<j) return false;
            jump=Math.max(jump,j+nums[j]);
            
            
            if(jump>=n-1) return true;
            j++;
          
        }
        return false;
    }
}

/*

2 3 1 1 4
2 4 3 4 8


3 2 1 0 4
3 3 3 3 8



*/