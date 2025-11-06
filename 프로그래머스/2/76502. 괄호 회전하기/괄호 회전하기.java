import java.io.*;
import java.util.*;

class Solution {
    static Stack<Character> stack;
    static int count;
    public int solution(String s) {
        count = 0;
        stack = new Stack<>();
        
        // s 길이만큼 반복
        for(int i = 0; i < s.length(); i++){
            if(check(s)){
                count++;
            }
            
            s = s.substring(1) + s.charAt(0);
        }
        return count;
    }
    
    public static boolean check(String s){
        // 시작점 확인
        if(s.charAt(0) != '[' && s.charAt(0)!='{' && s.charAt(0)!='('){
            return false;
        }
        
        for(int i = 0; i<s.length(); i++){
            // 여는 괄호
            if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else{  // 닫는 괄호
                
                if(stack.isEmpty()){
                    return false;
                }
                
                else if(stack.peek() == '[' && s.charAt(i) == ']'){
                    stack.pop();
                }else if(stack.peek() == '{' && s.charAt(i) == '}'){
                    stack.pop();
                }else if(stack.peek() == '(' && s.charAt(i) == ')'){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}