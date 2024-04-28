class Solution {
    Map<Integer, List<Integer>> graph;
    int[] count;
    int[] res;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        graph = new HashMap<>();
        count = new int[n];
        res = new int[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        dfs(0, -1);
        dfs2(0, -1);

        return res;
    }

    private void dfs(int node, int parent) {
        count[node] = 1;
        for (int child : graph.getOrDefault(node, new ArrayList<>())) {
            if (child != parent) {
                dfs(child, node);
                count[node] += count[child];
                res[node] += res[child] + count[child];
            }
        }
    }

    private void dfs2(int node, int parent) {
        for (int child : graph.getOrDefault(node, new ArrayList<>())) {
            if (child != parent) {
                res[child] = res[node] - count[child] + (count.length - count[child]);
                dfs2(child, node);
            }
        }
    }
}