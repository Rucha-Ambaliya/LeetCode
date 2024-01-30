class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> val = new Stack<>();
        int n = tokens.length;
        for(int i = 0; i < n; i++){
            String ch = tokens[i];
            if(!ch.equals("+") && 
               !ch.equals("-") &&
               !ch.equals("*") &&
               !ch.equals("/") 
              ) val.add(Integer.parseInt(ch));
            else{
                int v2 = val.pop();
                int v1 = val.pop();
                if(ch.equals("+")) val.add(v1 + v2);
                else if(ch.equals("-")) val.add(v1 - v2);
                else if(ch.equals("/")) val.add(v1 / v2);
                else if(ch.equals("*")) val.add(v1 * v2);   
            }
        }
        int ans = val.pop();
        return ans;
    }
}