
import java.util.*;

class Solution {
    int MOD = 1000000007;
    int[][] comb;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        comb = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] =
                    (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
        }

        return (int) ((solve(list) - 1 + MOD) % MOD);
    }

    private long solve(List<Integer> nums) {
        if (nums.size() <= 2) {
            return 1;
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        int root = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }

        long leftWays = solve(left);
        long rightWays = solve(right);

        int l = left.size();
        int r = right.size();

        long ways = comb[l + r][l];

        ways = (ways * leftWays) % MOD;
        ways = (ways * rightWays) % MOD;

        return ways;
    }
}
