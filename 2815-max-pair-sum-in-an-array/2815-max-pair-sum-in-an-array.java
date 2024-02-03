class Solution {
    public int maxSum(int[] nums) {
        int[] maxDigitNum = new int[10];
        int maxSum = -1;

        for (int num : nums) {
            int maxDigit = getMaxDigit(num);
            if(maxDigitNum[maxDigit] != 0){
                maxSum = Math.max(maxSum, maxDigitNum[maxDigit] + num);
                maxDigitNum[maxDigit] = Math.max(maxDigitNum[maxDigit], num);
            } else {
                maxDigitNum[maxDigit] = num;
            }
        }

        return (maxSum == -1) ? -1 : maxSum;
    }

    public int getMaxDigit(int num) {
        int maxDigit = 0;

        while (num != 0) {
            int r = num % 10;
            maxDigit = Math.max(maxDigit, r);
            num /= 10;
        }

        return maxDigit;
    }
}
