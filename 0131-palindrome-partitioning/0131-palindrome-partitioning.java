class Solution {

    public boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public void fun(int i, int n, String s,
                    List<List<String>> ans,
                    List<String> list) {

        if (i == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j < n; j++) {
            if (isPalindrome(s, i, j)) {
                list.add(s.substring(i, j + 1));
                fun(j + 1, n, s, ans, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        fun(0, s.length(), s, ans, new ArrayList<>());
        return ans;
    }
}
