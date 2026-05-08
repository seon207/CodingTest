import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int total = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int day = 0; 
        
        for(int i = 0; i < progresses.length; i++){
            if(progresses[i] + speeds[i] * day < 100){   // 완료 안됨
                while(progresses[i] + speeds[i] * day < 100) day++; // 날짜 추가
                list.add(1);
            }else{  // 이미 완료된 상태
                int idx = list.size()-1;
                list.set(idx, list.get(idx) + 1);
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}