import java.io.*;
import java.util.*;


class Solution {
    static Map<String, String> parent;  // 관계
    static Map<String, Integer> money;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        parent = new HashMap<>();
        money = new HashMap<>();
        
        // 관계 저장
        for(int i = 0; i < enroll.length; i++){
            parent.put(enroll[i], referral[i]);
        }
        
        // 총 이익 저장
        for(int i = 0; i < seller.length; i++){
            div(seller[i], amount[i] * 100);
        }
        
        
        int[] answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++){
            answer[i] = money.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
    
    public static void div(String person, int sum){
        int rest = sum / 10;
        
        money.put(person, money.getOrDefault(person, 0) + sum - rest);
        if(rest > 0 && parent.containsKey(person)){
            div(parent.get(person), rest);
        }
    }
}