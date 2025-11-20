import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;
        
        for(int i = 0; i < works.length; i++){
            q.offer(works[i]);
        }
        
        while(n > 0){
            int work = q.poll();
            if(work == 0) break;
            work-=1;
            q.offer(work);
            n-=1;
        }
        
        for(int l: q){
            answer+=(long)l*l;
        }
        return answer;
    }
}