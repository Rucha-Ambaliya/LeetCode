import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        for (char task : tasks) {
            counter[task - 'A']++;
        }
        Arrays.sort(counter);
        int maxFreq = counter[25];
        int idleTime = (maxFreq - 1) * n;
        for (int i = 24; i >= 0 && counter[i] > 0; i--) {
            idleTime -= Math.min(counter[i], maxFreq - 1);
        }
        idleTime = Math.max(0, idleTime);
        return tasks.length + idleTime;
    }
}
