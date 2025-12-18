import java.io.*;
import java.util.*;

class Solution
{
    static Stack<Character> stack;
    public int solution(String s)
    {
        stack = new Stack<>();
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty()){    // 비어있으면 추가
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i) == stack.peek()){
                stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        
        if(stack.isEmpty()){
            answer = 1;
        }else{
            answer = 0;
        }
        
        return answer;
    }
}