import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<String> list;
    static String[] words = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        dfs("", 0);
        for(int i = 0;  i<list.size(); i++){
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    public static void dfs(String s, int len){
        list.add(s);
        if(len == 5) return;
        for(int i = 0; i < 5; i++){
            dfs(s + words[i], len + 1);
        }   
    }
}