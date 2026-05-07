import java.io.*;
import java.util.*;

class Solution {
    static int[] pick, used, order;
    static int totalPicks, min;
    static int[][] tired;
    public int solution(int[] picks, String[] minerals) {
        tired = new int[][]{{1,1,1}, {5,1,1}, {25,5,1}};  // 피로도
        int answer = 0;
        pick = picks;
        order = new int[minerals.length];
        used = new int[3];  // 곡괭이 사용 판단
        min = Integer.MAX_VALUE;
        //  총 곡괭이 수
        for(int i: picks){
            totalPicks += i;
        }
        
        for(int i = 0; i < minerals.length; i++){
            String s = minerals[i];
            order[i] = s.equals("diamond") ? 0: s.equals("iron")? 1:2;
        }
        mine(0,0,0,0);
        answer = min;
        return answer;
    }
    
    public static void mine(int count, int depth, int energy, int picks){
        if(energy > min) return;
        
        if(depth < order.length && count > 0){
            mine(count-1, depth+1, energy+tired[picks][order[depth]],picks);
            return;
        }
        
        // 사용할 곡괭이 없거나 모든 광물을 캠
        if(depth == order.length || used[0] + used[1] + used[2] == totalPicks){
            min = Math.min(energy, min);
            return;
        }
        
        for(int i = 0; i < 3; i++){  
            if(used[i] == pick[i]) continue;
            used[i]++;
            mine(4, depth + 1, energy + tired[i][order[depth]], i);
            used[i]--;
        }
    }
}