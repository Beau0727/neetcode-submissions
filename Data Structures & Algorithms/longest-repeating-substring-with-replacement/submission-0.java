class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxCount = 0; // 窗口内出现次数最多的字符的出现次数
        int ans = 0;
        char[] chars = s.toCharArray();
        
        for (int right = 0; right < chars.length; right++) {
            int idx = chars[right] - 'A';
            count[idx]++;
            maxCount = Math.max(maxCount, count[idx]);
            
            // 窗口长度 - 最多字符数 > k，说明替换次数不足，收缩左边界
            while (right - left + 1 - maxCount > k) {
                count[chars[left] - 'A']--;
                left++;
            }
            
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}