import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<Integer> list;
    public int[] solution(String s) {
        list = new ArrayList<>();
        s = s.substring(2, s.length()-2).replace("},{", "-");
        String[] ss = s.split("-");
        
        Arrays.sort(ss, (s1, s2) -> s1.length() - s2.length());
        
        for(String str : ss){
            String[] strs = str.split(",");
            for(int i = 0; i < strs.length; i++){
                int num = Integer.parseInt(strs[i]);
                if(!list.contains(num)){
                    list.add(num);
                }
            }
        }
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}