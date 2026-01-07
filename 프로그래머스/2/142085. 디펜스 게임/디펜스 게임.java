import java.io.*;
import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq;
    public int solution(int n, int k, int[] enemy) {
        pq = new PriorityQueue<>(Collections.reverseOrder());    //  최대
        for(int i = 0; i<enemy.length; i++){
            pq.offer(enemy[i]);
            n -= enemy[i];
            
            if(n < 0){    // 라운드 끝났을 때
                if(k == 0){ // 무적권 없음
                    return i;
                }
                k--;
                n += pq.poll();   // 가장 많은 적이 나온 라운드를 무적권으로 처리
            }
        }
        return enemy.length;
    }
}