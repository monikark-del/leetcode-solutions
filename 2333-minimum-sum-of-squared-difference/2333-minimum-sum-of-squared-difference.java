class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        long[] diff = new long[n];

        long total = 0;
        long max = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            total += diff[i];
            max = Math.max(max, diff[i]);
        }

        long k = (long) k1 + k2;

        if (k >= total) {
            return 0;
        }

        long low = 0;
        long high = max;

        while (low < high) {
            long mid = low + (high - low) / 2;

            long required = 0;

            for (int i = 0; i < n; i++) {
                if (diff[i] > mid) {
                    required += diff[i] - mid;
                }
            }

            if (required <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long level = low;
        long used = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (diff[i] > level) {
                used += diff[i] - level;
                diff[i] = level;
            }
        }

        long remaining = k - used;

        for (int i = 0; i < n; i++) {
            if (remaining > 0 && diff[i] == level && level > 0) {
                diff[i]--;
                remaining--;
            }

            ans += diff[i] * diff[i];
        }

        return ans;
    }
}