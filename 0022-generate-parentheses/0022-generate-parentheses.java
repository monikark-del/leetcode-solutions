class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        backtrack(ans, "", 0, 0, n);

        return ans;
    }

    public void backtrack(List<String> ans, String s, int open, int close, int n) {

        if (s.length() == 2 * n) {
            ans.add(s);
            return;
        }

        // We can add '(' if we still have opening brackets left
        if (open < n) {
            backtrack(ans, s + "(", open + 1, close, n);
        }

        // We can add ')' only if there is an unmatched '('
        if (close < open) {
            backtrack(ans, s + ")", open, close + 1, n);
        }
    }
}