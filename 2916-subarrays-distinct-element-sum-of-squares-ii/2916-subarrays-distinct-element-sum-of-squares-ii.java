
class Solution {
    static final long MOD = 1_000_000_007L;

    class SegmentTree {
        long[] sum;
        long[] sq;
        long[] lazy;
        int n;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sq = new long[4 * n];
            lazy = new long[4 * n];
        }

        void apply(int node, int left, int right, long val) {
            long len = right - left + 1L;

            sq[node] = (sq[node]
                    + 2L * val % MOD * sum[node] % MOD
                    + val * val % MOD * len % MOD) % MOD;

            sum[node] = (sum[node] + val * len) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
        }

        void push(int node, int left, int right) {
            if (lazy[node] == 0 || left == right) {
                return;
            }

            int mid = (left + right) / 2;

            apply(node * 2, left, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, right, lazy[node]);

            lazy[node] = 0;
        }

        void update(int node, int left, int right,
                    int ql, int qr, long val) {

            if (ql > right || qr < left) {
                return;
            }

            if (ql <= left && right <= qr) {
                apply(node, left, right, val);
                return;
            }

            push(node, left, right);

            int mid = (left + right) / 2;

            update(node * 2, left, mid, ql, qr, val);
            update(node * 2 + 1, mid + 1, right, ql, qr, val);

            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
            sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
        }

        long query(int node, int left, int right,
                   int ql, int qr) {

            if (ql > right || qr < left) {
                return 0;
            }

            if (ql <= left && right <= qr) {
                return sq[node];
            }

            push(node, left, right);

            int mid = (left + right) / 2;

            long a = query(node * 2, left, mid, ql, qr);
            long b = query(node * 2 + 1, mid + 1, right, ql, qr);

            return (a + b) % MOD;
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;

        int[] last = new int[100001];
        Arrays.fill(last, -1);

        SegmentTree st = new SegmentTree(n);
        long result = 0;

        for (int i = 0; i < n; i++) {
            int previous = last[nums[i]];

            st.update(1, 0, n - 1,
                      previous + 1, i, 1);

            result = (result
                    + st.query(1, 0, n - 1, 0, n - 1)) % MOD;

            last[nums[i]] = i;
        }

        return (int) result;
    }
}
