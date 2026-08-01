class Solution {
    public int maximumWidth(int[] nums) {

        Arrays.sort(nums);

        Set<Integer> hs = new HashSet<>();
        Map<Integer, Integer> mp = new HashMap<>();

        int mx = 0;

        for (int x : nums) {
            hs.add(x);
            mp.put(x, mp.getOrDefault(x, 0) + 1);
            mx = Math.max(mx, x);
        }

        Map<Integer, Integer> width = new HashMap<>(mp);

        for (int x : hs) {
            for (int y : hs) {

                if (x > y)
                    continue;

                int add;

                if (x == y)
                    add = mp.get(x) / 2;
                else
                    add = Math.min(mp.get(x), mp.get(y));

                int sum = x + y;

                width.put(sum, width.getOrDefault(sum, 0) + add);
            }
        }

        int res = 0;

        for (int val : width.values())
            res = Math.max(res, val);

        return res;
    }
}