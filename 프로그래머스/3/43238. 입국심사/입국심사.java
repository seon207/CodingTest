import java.io.*;
import java.util.*;

class Solution {
    static long time = 1000000000;
    public long solution(int n, int[] times) {
        Arrays.sort(times); // 오름차순 정렬
        long start = 0;
        long end = times[times.length - 1] * (long)n;  // 최대로 걸리는 시간
        long answer = 0;
        while(start <= end){
            long mid = (start + end) / 2;
            long ppl = 0;
            for(int i = 0; i < times.length; i++){
                ppl += mid / times[i];  // 검사 받을 수 있는 사람 수
            }
            
            if(ppl < n){    // 다 받을 수 없음
                start = mid + 1;
            }
            else{  // 다 받을 수 있음
                end = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}