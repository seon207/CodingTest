import java.io.*;
import java.util.*;

class Solution {
    public class Job{
        double start;
        double end;
        
        public Job(double start, double end){
            this.start = start;
            this.end = end;
        }
    }
    
    static ArrayList<Job> list;
    public int solution(String[] lines) {
        list = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            String[] s = lines[i].split(" ");
            convertTime(s[1], s[2]);
        }
        
        int answer = 1;
        
        for(int i = 0; i < list.size(); i++){
            int count = 0;
            double end = list.get(i).end;
            for(int j = 0; j < list.size(); j++){
                if(list.get(j).start < end + 1000 && list.get(j).end >= end){
                    count++;
                }
            }
            
            answer = Math.max(count, answer);
        }
        return answer;
    }
    
    
    // 시간 변환
    public void convertTime(String s, String dur){
        String[] durs = dur.split("s");
        String[] times = s.split(":");
        double endTime = Double.parseDouble(times[0]) * 3600;
        endTime += Double.parseDouble(times[1]) * 60;
        endTime *= 1000;
        endTime += Double.parseDouble(times[2]) * 1000;
        double startTime = endTime - (Double.parseDouble(durs[0])*1000) + 1;
        list.add(new Job(startTime, endTime));
    }
}