class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        int n = intervals.length;
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int i;

        for (i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (end < newStart) {
                ArrayList<Integer> subList = new ArrayList<>();
                subList.add(start);
                subList.add(end);
                ansList.add(subList);
            } else if (start > newEnd) {
                ArrayList<Integer> subList = new ArrayList<>();
                subList.add(newStart);
                subList.add(newEnd);
                ansList.add(subList);
                break;
            } else {
                newStart = Math.min(newStart, start);
                newEnd = Math.max(newEnd, end);
            }
        }

        if (i == n) {
            ArrayList<Integer> subList = new ArrayList<>();
            subList.add(newStart);
            subList.add(newEnd);
            ansList.add(subList);
        } else {
            for (; i < n; i++) {
                ansList.add(new ArrayList<>(Arrays.asList(intervals[i][0], intervals[i][1])));
            }
        }

        int[][] result = new int[ansList.size()][2];
        for (i = 0; i < ansList.size(); i++) {
            result[i][0] = ansList.get(i).get(0);
            result[i][1] = ansList.get(i).get(1);
        }
        return result;
    }
}
