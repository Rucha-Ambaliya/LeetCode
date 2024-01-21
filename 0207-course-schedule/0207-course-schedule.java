class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] vis = new boolean[numCourses];
        boolean[] rec = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i] && hasCycle(prerequisites, i, vis, rec)) {
                return false;
            }
        }

        return true;
    }
    public boolean hasCycle(int[][] prerequisites, int curr, boolean[] vis, boolean[] rec){
        vis[curr] = true;
        rec[curr] = true;
        for(int i = 0; i < prerequisites.length; i++){
            if (prerequisites[i][0] == curr) {
                int nbr = prerequisites[i][1];
                if (rec[nbr]) {
                    return true;  // Cycle detected
                } else if (!vis[nbr]) {
                    if (hasCycle(prerequisites, nbr, vis, rec)) {
                        return true;
                    }
                }
            }
        }
        rec[curr] = false;
        return false;
    }
    
}