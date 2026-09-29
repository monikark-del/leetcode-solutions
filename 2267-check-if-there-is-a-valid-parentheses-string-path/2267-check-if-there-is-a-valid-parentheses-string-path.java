class Solution {
    int m, n;
    char[][] grid;
    Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        // Path length must be even for a valid parentheses string
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // First character must be '(' and last must be ')'
        if (grid[0][0] != '(' || grid[m - 1][n - 1] != ')') {
            return false;
        }

        dp = new Boolean[m][n][m + n];

        return dfs(0, 0, 0);
    }

    boolean dfs(int row, int col, int balance) {

        // Update balance
        if (grid[row][col] == '(') {
            balance++;
        } else {
            balance--;
        }

        // Too many ')' characters
        if (balance < 0) {
            return false;
        }

        // Remaining cells are not enough to close all '('
        int remaining = (m - row - 1) + (n - col - 1);

        if (balance > remaining) {
            return false;
        }

        // Destination reached
        if (row == m - 1 && col == n - 1) {
            return balance == 0;
        }

        if (dp[row][col][balance] != null) {
            return dp[row][col][balance];
        }

        boolean result = false;

        // Move down
        if (row + 1 < m) {
            result = dfs(row + 1, col, balance);
        }

        // Move right
        if (!result && col + 1 < n) {
            result = dfs(row, col + 1, balance);
        }

        dp[row][col][balance] = result;

        return result;
    }
}