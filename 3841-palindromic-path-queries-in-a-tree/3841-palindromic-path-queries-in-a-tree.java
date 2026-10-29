
import java.util.*;

class Solution {
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        int[][] up = new int[n][LOG];
        int[] depth = new int[n];
        int[] tin = new int[n];
        int[] tout = new int[n];
        int[] parent = new int[n];
        int[] size = new int[n];
        int[] initialMask = new int[n];
        int[] bit = new int[n + 1];
        char[] chars = s.toCharArray();

        Arrays.fill(parent, -1);

        int[] stack = new int[n];
        int[] order = new int[n];
        int top = 0, count = 0, timer = 0;

        stack[top++] = 0;
        parent[0] = 0;

        while (top > 0) {
            int u = stack[--top];

            tin[u] = timer++;
            order[count++] = u;
            size[u] = 1;

            up[u][0] = parent[u];
            for (int j = 1; j < LOG; j++) {
                up[u][j] = up[up[u][j - 1]][j - 1];
            }

            initialMask[u] =
                (u == 0 ? 0 : initialMask[parent[u]])
                ^ (1 << (chars[u] - 'a'));

            for (int v : graph[u]) {
                if (parent[v] == -1) {
                    parent[v] = u;
                    depth[v] = depth[u] + 1;
                    stack[top++] = v;
                }
            }
        }

        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            size[parent[u]] += size[u];
        }

        for (int u = 0; u < n; u++) {
            tout[u] = tin[u] + size[u];
        }

        List<Boolean> answer = new ArrayList<>();

        for (String q : queries) {
            String[] p = q.split(" ");

            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);

                int delta = (1 << (chars[u] - 'a'))
                          ^ (1 << (c - 'a'));

                if (delta != 0) {
                    for (int i = tin[u] + 1; i <= n; i += i & -i) {
                        bit[i] ^= delta;
                    }

                    for (int i = tout[u] + 1; i <= n; i += i & -i) {
                        bit[i] ^= delta;
                    }

                    chars[u] = c;
                }
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);

                int a = u, b = v;

                if (depth[a] < depth[b]) {
                    int temp = a;
                    a = b;
                    b = temp;
                }

                int diff = depth[a] - depth[b];

                for (int j = 0; j < LOG; j++) {
                    if ((diff & (1 << j)) != 0) {
                        a = up[a][j];
                    }
                }

                if (a != b) {
                    for (int j = LOG - 1; j >= 0; j--) {
                        if (up[a][j] != up[b][j]) {
                            a = up[a][j];
                            b = up[b][j];
                        }
                    }
                    a = parent[a];
                }

                int mask = initialMask[u] ^ initialMask[v]
                         ^ (1 << (chars[a] - 'a'));

                for (int i = tin[u] + 1; i > 0; i -= i & -i) {
                    mask ^= bit[i];
                }

                for (int i = tin[v] + 1; i > 0; i -= i & -i) {
                    mask ^= bit[i];
                }

                answer.add((mask & (mask - 1)) == 0);
            }
        }

        return answer;
    }
}
