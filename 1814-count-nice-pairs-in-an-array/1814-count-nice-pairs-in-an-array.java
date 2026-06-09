class Solution {
    int MOD = 1000000007;
    public int countNicePairs(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int result = 0;

        for( int i = 0; i < n; i++ ) {
            int reverseNum = reverseNum(nums[i]);
            nums[i] -= reverseNum;
        }

        for( int num : nums ) {
            if( mp.containsKey(num) ) {
                int count = mp.get(num);
                result = ( result + count ) % MOD;

                mp.put(num, mp.get(num) + 1);
            }
            else{
                mp.put(num, 1);
            }
        }
        return result;
    }

    private int reverseNum(int num) {
        int newNum = 0;
        while(num > 0) {
            int rem = num % 10;
            newNum = newNum * 10 + rem;
            num /= 10; 
        }
        return newNum;
    }
}
/*

[42,11,1,97]
[24,11,1,79]


*/