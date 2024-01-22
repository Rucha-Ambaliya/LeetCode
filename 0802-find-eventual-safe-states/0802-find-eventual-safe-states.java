class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, state)) {
                result.add(i);
            }
        }
        
        return result;
    }
    private static boolean dfs(int[][] graph, int node, int[] state) {
        if (state[node] != 0) {
            return state[node] == 2;
        }

        state[node] = 1;

        for (int neighbor : graph[node]) {
            if (!dfs(graph, neighbor, state)) {
                return false;
            }
        }

        state[node] = 2;

        return true;
    }
}