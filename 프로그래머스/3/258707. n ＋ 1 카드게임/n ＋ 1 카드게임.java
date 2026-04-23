import java.io.*;
import java.util.*;

class Solution {
    static Set<Integer> ori, addi;
    static int N;
    public int solution(int coin, int[] cards) {
        ori = new HashSet<>();
        addi = new HashSet<>();
        N = cards.length;
        int idx = N/3;
        int target = N+1;
        for(int i = 0; i < idx; i++){   // 초기 카드
            ori.add(cards[i]);
        }
        
        int answer = 0;
        while(true){
            answer++;
            
            if(idx > N-1){
                break;
            }
            
            // 두장 추가
            addi.add(cards[idx]);
            addi.add(cards[idx + 1]);
            boolean flag = false;
            idx+=2;
            
            // 기존 카드로 해결
            for(int num: ori){
                if(ori.contains(target - num)){
                    ori.remove(num);
                    ori.remove(target - num);
                    flag = true;
                    break;
                }
            }
            
            // 기존+추가 사용해서 해결
            if(!flag && coin > 0){
                for(int num : ori){
                    if(addi.contains(target - num)){
                        coin-=1;
                        ori.remove(num);
                        addi.remove(target-num);
                        flag = true;
                        break;
                    }
                }
            }
        
            
            // 추가 카드만 사용해서 해결
            if(!flag && coin > 1){
                for(int num:addi){
                    if(addi.contains(target - num)){
                        coin-=2;
                        addi.remove(num);
                        addi.remove(target-num);
                        flag = true;
                        break;
                    }
                }
            }
            
            if(!flag) break;
        }
        
        return answer;
    }
}