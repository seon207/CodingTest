import java.util.*;
class Solution {
    public int[] solution(String s) {
        int totalZero = 0;
        int cons = 0;
        String after = s;
        int length = 0;
        while(!after.equals("1")){
        String afterConvert = after.replace("0", "");
        totalZero += after.length() - afterConvert.length();
        after = convert(afterConvert.length());
        cons++;
        }
        int[] answer = new int[]{cons, totalZero};
        return answer;
    }
    
    public String convert(int num){
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            sb.append(num % 2);
            num /= 2;
        }
        
        return sb.reverse().toString();
    }
}