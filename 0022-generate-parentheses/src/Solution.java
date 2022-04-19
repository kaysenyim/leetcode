import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        gen(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void gen(List<String> res, StringBuilder sb, int l, int r, int n) {
        if (l > n || r > n || r > l) {
            return;
        }
        if (l == n && r == n) {
            res.add(sb.toString());
        }

        sb.append("(");
        gen(res, sb, l + 1, r, n);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(")");
        gen(res, sb, l, r + 1, n);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        List<String> res = new Solution().generateParenthesis(3);
        System.out.println(res);
    }
}
