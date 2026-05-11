import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<Character>();
        int answer = -1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(c);
            }
            else if(stack.peek() == c){
                stack.pop();
            }else{
                stack.push(c);
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