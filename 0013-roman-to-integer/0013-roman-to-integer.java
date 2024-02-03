class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = n - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if(ch == 'I'){
                ans += 1;
            }
            else if(ch == 'V'){
                if(i != 0 && s.charAt(i - 1) == 'I'){
                    ans += 4;
                    i--;
                } else {
                    ans += 5;
                }
            }
            else if(ch == 'X'){
                if(i != 0 && s.charAt(i - 1) == 'I'){
                    ans += 9;
                    i--;
                } else {
                    ans += 10;
                }
            }
            else if(s.charAt(i) == 'L'){
                if(i != 0 && s.charAt(i - 1) == 'X'){
                    ans += 40;
                    i--;
                } else {
                    ans += 50;
                }
            }
            else if(ch == 'C'){
               if(i != 0 && s.charAt(i - 1) == 'X'){
                    ans += 90;
                    i--;
                } else {
                    ans += 100;
                }
            }
            else if(ch == 'D'){
               if(i != 0 && s.charAt(i - 1) == 'C'){
                    ans += 400;
                    i--;
                } else {
                    ans += 500;
                }
            }
            else if(ch == 'M'){
               if(i != 0 && s.charAt(i - 1) == 'C'){
                    ans += 900;
                    i--;
                } else {
                    ans += 1000;
                }
            }
        }
        return ans;
    }
}