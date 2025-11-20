import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> count = new HashMap<>();  // 총 플레이 횟수
        HashMap<String, HashMap<Integer, Integer>> map = new HashMap<>();    // 순서
        
        for(int i = 0; i < plays.length; i++){
            if(!count.containsKey(genres[i])){  // 장르 없을 때
                HashMap<Integer, Integer> m = new HashMap<>();
                m.put(i, plays[i]);
                map.put(genres[i], m);
                count.put(genres[i], plays[i]);
            }else{  // 이미 있을 때
                map.get(genres[i]).put(i,plays[i]);
                count.put(genres[i], count.get(genres[i]) + plays[i]);
            }
        }
        
        // 장르별 재생횟수
        List<String> keys = new ArrayList<>(count.keySet());
        Collections.sort(keys, (k1, k2) -> count.get(k2) - count.get(k1));
        
        for(String k: keys){
            HashMap<Integer, Integer> m = map.get(k);
            List<Integer> gk = new ArrayList<>(m.keySet());
            
            Collections.sort(gk, (k1, k2) -> m.get(k2) - m.get(k1));
            answer.add(gk.get(0));
            if(gk.size() > 1){
                answer.add(gk.get(1));
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}