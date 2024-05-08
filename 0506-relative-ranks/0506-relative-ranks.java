class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        int n = score.length;
        String[] answer = new String[n];
        Integer[] sortedScores = Arrays.stream(score).boxed().sorted(Collections.reverseOrder()).toArray(Integer[]::new);
        HashMap<Integer, String> rankMap = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            int currentScore = sortedScores[i];
            if(i == 0)
                rankMap.put(currentScore, "Gold Medal");
            else if(i == 1)
                rankMap.put(currentScore, "Silver Medal");
            else if(i == 2)
                rankMap.put(currentScore, "Bronze Medal");
            else
                rankMap.put(currentScore, String.valueOf(i + 1));
        }
        
        for(int i = 0; i< n; i++){
            answer[i] = rankMap.get(score[i]);
        }
        
        return answer;
    }
}