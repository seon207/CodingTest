import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; i++){
            q.offer(new int[]{priorities[i], i});
            pq.offer(priorities[i]);
        }
        
        int count = 0;
        while(true){
            int[] cur = q.poll();
            if(cur[0] < pq.peek()){ // 우선순위 낮음
                q.offer(cur);  // 다시 넣기
            }else{
                pq.poll();  // 우선순위 빼기
                count++;
                if(cur[1] == location){ // 같음
                break;
            }
            }
            
            
            
        }
        
        return count;
    }
}