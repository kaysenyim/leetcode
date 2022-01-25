import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int startIdx = 0;
        // 记录处于窗口的字符
        Set<Character> tmp = new HashSet<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 检查窗口中是否存在c
            if (tmp.contains(c)) {
                // 移动窗口
                // 新窗口从重复字符下一位置，到当前位置
                int nextIdx = s.indexOf(c, startIdx) + 1;
                // 移除窗口外的字符
                for (int j = startIdx; j < nextIdx; j++) {
                    char c1 = s.charAt(j);
                    tmp.remove(c1);
                }
                startIdx = nextIdx;
            }
            tmp.add(c);
            int len = 1 + i - startIdx;
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution o = new Solution();
        int len = o.lengthOfLongestSubstring("tmnmzuxt");
        System.out.println(len);
    }
}
