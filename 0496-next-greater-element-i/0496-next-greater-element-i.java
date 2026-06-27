class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Deque<Integer> st = new ArrayDeque<>();
        Map<Integer, Integer> nextGreater = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            int curr = nums2[i];

            while (!st.isEmpty() && st.peek() <= curr)
                st.pop();

            nextGreater.put(curr, st.isEmpty() ? -1 : st.peek());
            st.push(curr);
        }

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++)
            ans[i] = nextGreater.get(nums1[i]);

        return ans;
    }
}