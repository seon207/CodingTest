import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i = 1; i <= yellow; i++){
            int b = brown;
            int width = yellow/i;
            int height = yellow/width;
            
            if(width * height == yellow){
            b -= (width * 2) + (height * 2) + 4;
            if(b == 0){
                answer[1] = height + 2;
                answer[0] = width + 2;
                break;
            }
            }
        }
        
        return answer;
    }
}