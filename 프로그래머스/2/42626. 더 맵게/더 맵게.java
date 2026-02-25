import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer = 0;
        for(int s: scoville){
            queue.offer(s);
        }
        while(queue.size() >= 2){
            if(queue.peek() >= K) break;
            int first = queue.poll();
            int sec = queue.poll();
            
            int result = first + (sec * 2);
            queue.offer(result);
            answer++;
        }
        
        if(queue.peek() < K) answer = -1;
        return answer;
    }
}