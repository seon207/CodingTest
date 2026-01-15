import java.io.*;
import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = StringToInt(play_time);
        int advTime = StringToInt(adv_time);
        
        long[] count = new long[playTime + 2];
        for(String log : logs){ // 전체 재생시간 중 재생되고 있는 수
            String[] duration = log.split("-");
            int start = StringToInt(duration[0]);
            int end = StringToInt(duration[1]);
            
            count[start]++;
            count[end]--;
        }

        // 각 시간대의 재생 수
        for(int i = 1; i <= playTime; i++){
            count[i] += count[i - 1];
        }
        
        // 누적 재생시간
        for(int i = 1; i<= playTime; i++){
            count[i] += count[i-1];
        }
        
        // 최대 재생 시간
        long max = count[advTime - 1];
        
        int cur = 0;
        for (int start = 1; start + advTime - 1 <= playTime; start++) {
            int end = start + advTime - 1;
            long t = count[end] - count[start - 1];

            if (max < t) {
                max = t;
                cur = start;
            }
        }
        
        int h = cur/3600;
        int left = cur%3600;
        int m = left/60;
        left %= 60;
        String answer = String.format("%02d:%02d:%02d",h,m,left);
        
        return answer;
    }
    
    public static int StringToInt(String time){
        String[] h = time.split(":");
        int hour = Integer.parseInt(h[0]);
        int min = Integer.parseInt(h[1]);
        int sec = Integer.parseInt(h[2]);
        return hour * 3600 + min * 60 + sec;
    }
}