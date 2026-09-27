class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder("0".repeat(n));

        int total = 1 << n;
        boolean[] used = new boolean[total];

        ans.add(0);
        used[0] = true;

        helper(ans, sb, total, used);

        return ans;
    }

    private void helper(List<Integer> ans, StringBuilder sb,
                        int total, boolean[] used) {

        if (ans.size() == total)
            return;

        for (int i = 0; i < sb.length(); i++) {
            char original = sb.charAt(i);

            sb.setCharAt(i, original == '0' ? '1' : '0');

            int value = Integer.parseInt(sb.toString(), 2);

            if (!used[value]) {
                used[value] = true;
                ans.add(value);

                helper(ans, sb, total, used);
                return;
            }

            sb.setCharAt(i, original);
        }
    }
}