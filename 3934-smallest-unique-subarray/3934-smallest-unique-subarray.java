import java.util.*;

class Solution {

    static final long BASE1 = 233;
    static final long BASE2 = 997;
    static final long MOD1 = 998244353;
    static final long MOD2 = 1000000007;

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        long[] h1 = new long[n + 1];
        long[] h2 = new long[n + 1];

        long[] p1 = new long[n + 1];
        long[] p2 = new long[n + 1];

        p1[0] = 1;
        p2[0] = 1;

        for (int i = 0; i < n; i++) {

            p1[i + 1] = p1[i] * BASE1 % MOD1;
            p2[i + 1] = p2[i] * BASE2 % MOD2;

            h1[i + 1] = (h1[i] * BASE1 + nums[i]) % MOD1;
            h2[i + 1] = (h2[i] * BASE2 + nums[i]) % MOD2;
        }

        int left = 1;
        int right = n;
        int ans = n;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (check(mid, n, h1, h2, p1, p2)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(int len, int n,
                          long[] h1, long[] h2,
                          long[] p1, long[] p2) {

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i + len <= n; i++) {

            int j = i + len;

            long hash1 = (h1[j] - h1[i] * p1[len] % MOD1 + MOD1) % MOD1;

            long hash2 = (h2[j] - h2[i] * p2[len] % MOD2 + MOD2) % MOD2;

            String key = hash1 + "," + hash2;

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int count : map.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}