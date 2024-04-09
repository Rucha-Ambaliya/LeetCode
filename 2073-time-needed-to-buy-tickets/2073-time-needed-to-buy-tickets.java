class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int posVal=tickets[k];
        int sum=0;
        for(int i = 0; i < tickets.length; i++) {
            if(tickets[i] >= posVal) {
                if(i <= k)
                    sum += posVal;
                else 
                    sum += posVal - 1;    
            }
            else {
                sum += tickets[i];
            }
        }
        return sum;
    }
}