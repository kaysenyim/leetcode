class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // dp[i][j]表示s[i...j]是否为回文传
        boolean[][] dp = new boolean[len][len];
        // 单个字符满足回文特征，所以dp[i][i]恒为true
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        // 状态转移
        // 1 回文串的子串也是回文串(dp[i][j] == dp[i+1][j-1])
        // 2 子串s[i+1...j-1]是回文串时，只需要判断c[i]与c[j]是否相等
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        Solution o = new Solution();
        String s = o.longestPalindrome("ab");
        System.out.println(s);
    }
}
