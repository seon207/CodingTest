import java.io.*;
import java.util.*;

class Solution {
    public static class Info implements Comparable<Info>{
        int num;
        int period;
        int time;
        public Info(int num, int period, int time){
            this.num = num;
            this.period = period;
            this.time = time;
        }
        
        @Override
        public int compareTo(Info o){
            if(this.time != o.time) return this.time - o.time;
            if(this.period != o.period) return this.period - o.period;
            return this.num - o.num;
        }
    }
    
    public int solution(int[][] jobs) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);   // 요청 시간 기준 정렬
        
        int idx = 0;    // 작업 중인 인덱스
        int total = 0;  // 요청 - 종료
        int time = 0;   // 현재 시간
        int job = 0;    // 처리 완료한 작업 개수
        
        while(job < jobs.length){
            while(idx < jobs.length && jobs[idx][0] <= time){
                pq.offer(new Info(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if(pq.isEmpty()){   // 비었으면 다음 요청시간으로
                time = jobs[idx][0];
                continue;
            }
            
            Info i = pq.poll();
            time += i.time;
            total += (time - i.period);
            job++;
        }
        
        int answer = total / jobs.length;
        return answer;
    }
}