import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<Character> list;
    static String[] trees;
    public int solution(String skill, String[] skill_trees) {
        trees = new String[skill_trees.length];
        list = new ArrayList<>();
        int answer = 0;
        for(int i = 0; i < skill.length(); i++){
            list.add(skill.charAt(i));
        }
        int idx = 0;
        for(int i = 0; i < skill_trees.length; i++){
            String after = "";
            String s = skill_trees[i];
            for(int j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                if(list.contains(c)){   // 있는 스킬이면
                    after+=c;
                }
            }
            trees[idx++] = after;
        }
        
        for (int i = 0; i < trees.length; i++) {
            String t = trees[i];
            if (skill.startsWith(t)) {
                answer++;
            }
        }
        
        
        return answer;
    }
    
    
}