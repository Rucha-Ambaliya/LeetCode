class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int wSize = n - k + 1;
        int[] maxArr = new int[wSize];
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[n];

        for(int i = n - 1; i >= 0; i--){
            nge[i] = n;
            while(stack.size() > 0 && nums[i] > nums[stack.peek()]){
                stack.pop();
            }
            if(stack.size() != 0){
                nge[i] = stack.peek();
            }
            stack.push(i);
        }
        int j = 0;
        for(int i = 0; i < wSize; i++){
            if(j >= i+k){
                j = i;
            }
            int max = 0;
            while(j < i + k){
                max = nums[j];
                j = nge[j];
            }
            maxArr[i] = max;
        }
        return maxArr;
    }
}