import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        
        int idx = 0;
        int cur = 0;
        while(idx < order.length){
            for(int i = cur + 1; i <= order[idx]; i++){
                stack.push(i);
            }
            
            if (stack.isEmpty() || order[idx] != stack.peek()) {
                break;
            }
            
            cur = Math.max(cur, order[idx]);
            while(!stack.isEmpty() && idx < order.length && stack.peek() == order[idx]){
                stack.pop();
                idx++;
                answer++; 
            }
        }
        
        return answer;
    }
}