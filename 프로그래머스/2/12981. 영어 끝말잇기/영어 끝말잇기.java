import java.io.*;
import java.util.*;

class Solution {
    static Map<String, Integer> map;

    public int[] solution(int n, String[] words) {
        map = new HashMap<>();
        map.put(words[0], 1);  

        int failIndex = -1;   

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];

            char last = prev.charAt(prev.length() - 1);
            char first = curr.charAt(0);

            if (first != last) {
                failIndex = i;
                break;
            }

            if (map.containsKey(curr)) {
                failIndex = i;
                break;
            }

            map.put(curr, 1);
        }

        if (failIndex == -1) {
            return new int[]{0, 0};
        }

        int person = (failIndex % n) + 1;     
        int round  = (failIndex / n) + 1;     

        return new int[]{person, round};
    }
}