import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<String> arrayList;
    public int solution(int cacheSize, String[] cities) {
        
        int answer = 0;
        arrayList = new ArrayList<>();
        if(cacheSize == 0){
            return cities.length * 5;
        }
        
        for(String s: cities){
            s = s.toLowerCase();
            if(arrayList.contains(s)){
                answer += 1;
                int idx = arrayList.indexOf(s);
                arrayList.remove(idx);
                arrayList.add(s);   // 가장 최신으로
            }else{
                if(arrayList.size() >= cacheSize){
                answer += 5;
                arrayList.remove(0);
                arrayList.add(s);
            }else{
                answer += 5;
                arrayList.add(s);
            }
                 }
        }
        return answer;
    }
}