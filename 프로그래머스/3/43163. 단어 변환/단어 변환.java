import java.io.*;
import java.util.*;

class Solution {
    static int count = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        boolean exists = false;
        for (String w : words) {
            if (w.equals(target)) {
                exists = true;
                break;
            }
        }
        if (!exists) return 0;

        boolean[] visited = new boolean[words.length];
        change(begin, target, visited, words, 0);

        return count == Integer.MAX_VALUE ? 0 : count;
    }

    public static void change(String word, String target, boolean[] visited, String[] words, int cnt) {
        if (word.equals(target)) {
            count = Math.min(count, cnt);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && check(word, words[i])) {
                visited[i] = true;
                change(words[i], target, visited, words, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean check(String word, String compare) {
        int diff = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != compare.charAt(i)) {diff++;}
        }
        if(diff!=1){
            return false;
        }
        return true;
    }
}