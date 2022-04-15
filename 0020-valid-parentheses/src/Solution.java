import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author kaysen
 * @see <a href="https://leetcode-cn.com/problems/valid-parentheses/">...</a>
 */
public class Solution {
    public static boolean isValid(String s) {
        Stack<Character> sc = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                sc.push(')');
            } else if (c == '[') {
                sc.push(']');
            } else if (c == '{') {
                sc.push('}');
            } else if (sc.isEmpty() || sc.pop() != c) {
                // 栈顶元素与当前元素不一致，即格式不正确
                return false;
            }
        }
        return sc.isEmpty();
    }

    public static void main(String[] args) {
        boolean f = isValid("()[]{}");
        System.out.println(f);
    }
}
