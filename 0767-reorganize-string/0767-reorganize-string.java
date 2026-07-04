class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] freq = new int[26];

        int max = 0, idx = 0;
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
            if (freq[c - 'a'] > max) {
                max = freq[c - 'a'];
                idx = c - 'a';
            }
        }

        if (max > (n + 1) / 2)
            return "";

        char[] ans = new char[n];
        int i = 0;

        while (freq[idx]-- > 0) {
            ans[i] = (char) ('a' + idx);
            i += 2;
        }

        for (int j = 0; j < 26; j++) {
            while (freq[j]-- > 0) {
                if (i >= n)
                    i = 1;
                ans[i] = (char) ('a' + j);
                i += 2;
            }
        }

        return new String(ans);
    }
}