class Solution {
    public int countVowelSubstrings(String word) {
        Map<Character, Integer> map = new HashMap();
        int count = 0;
        int left = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                map.put(c, i);
            } else {
                map.clear();
                left = i + 1;
            }
            if (map.size() == 5) {
                
                int min = Integer.MAX_VALUE;
                for (int index : map.values()) {
                    min = Math.min(min, index);
                }
                count += min - left + 1;
            }
        }        
        return count;
    }
}