import java.io.*;
import java.util.*;

class Solution {
    static int count;
    static boolean[] visited;
    public int solution(int[] numbers, int target) {
        count = 0;
        visited = new boolean[numbers.length];
        
        find(numbers, target, 0, 0);
        return count;
    }
    
    public static void find(int[] numbers, int target, int sum, int depth){
        if(depth == numbers.length){
            if(sum == target){ count++; }
            return;
        }
        
        find(numbers, target, sum + numbers[depth], depth + 1);
        find(numbers, target, sum - numbers[depth], depth + 1);
    
        
    }
}