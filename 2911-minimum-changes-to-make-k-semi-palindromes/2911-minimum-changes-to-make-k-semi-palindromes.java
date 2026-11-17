
class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();

        // Step 1: Find all proper divisors
        List<List<Integer>> factors = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            factors.add(new ArrayList<>());
        }

        for (int d = 1; d < n; d++) {
            for (int i = d * 2; i <= n; i += d) {
                factors.get(i).add(d);
            }
        }

        // Step 2: Precompute cost of every substring
        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int len = j - i + 1;
                int minCost = n;

                for (int d : factors.get(len)) {
                    int changes = 0;

                    for (int offset = 0; offset < d; offset++) {

                        int left = i + offset;
                        int right = j - d + 1 + offset;

                        while (left < right) {

                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    minCost = Math.min(minCost, changes);
                }

                cost[i][j] = minCost;
            }
        }

        // Step 3: Dynamic Programming
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], n);
        }

        dp[n][0] = 0;

        for (int i = n - 1; i >= 0; i--) {

            for (int parts = 1; parts <= k; parts++) {

                for (int j = i + 1; j < n; j++) {

                    dp[i][parts] = Math.min(
                        dp[i][parts],
                        cost[i][j] + dp[j + 1][parts - 1]
                    );
                }
            }
        }

        return dp[0][k];
    }
}
