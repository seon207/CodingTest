import java.io.*;
import java.util.*;

class Solution {
    static Queue<Integer> queue;
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        queue = new ArrayDeque<>();
        int answer = 0;
        int idx = 0;
        int w = 0;
        for(int i = 0; i < bridge_length; i++){   // 다리에 올라갈 수 있는만큼 초기화
            queue.offer(0);
        }
        while(!queue.isEmpty()){
            w -= queue.poll();  // 다리에서 내려오는 트럭
            answer++;
            if(idx < truck_weights.length){  // 트럭 남음
                if(w + truck_weights[idx] <= weight){
                    queue.offer(truck_weights[idx]);
                    w += truck_weights[idx];
                    idx++;
                }else{
                queue.offer(0);
            }
            }
        }
        
        return answer;
    }
}