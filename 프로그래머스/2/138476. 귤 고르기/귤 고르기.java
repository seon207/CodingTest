import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<Integer>();
        int answer = 0;
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        for(int key: map.keySet()){
            int v = map.get(key);
            list.add(v);
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            int value = list.get(i);
            sum += value;
            answer++;
            if(sum >= k) break;
        }
        
        
        return answer;
    }
}