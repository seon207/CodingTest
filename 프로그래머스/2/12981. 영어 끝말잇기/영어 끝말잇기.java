import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<String>();
        int[] answer = {};

        int count = 0;
        char last = words[0].charAt(words[0].length()-1);
        set.add(words[0]);
        for(int i = 1; i < words.length; i++){
            String w = words[i];
            char first = w.charAt(0);
            if(last != first){  // 끝
                count = i;
                break;
            }
            if(set.contains(w)){    // 이미 했던 단어
                count = i;
                break;
            }
            
            set.add(w);
            last = w.charAt(w.length() - 1);
        }
        
        if(count == 0){
            answer = new int[]{0,0};
        }else{
        
        int num = count % n + 1;
        int turn = count / n + 1;
        answer = new int[]{num, turn};
        }
    
        
        return answer;
    }
}