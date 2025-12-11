import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1]; // 두번째 숫자 기준 오름차순
            }
        });
    
        int end = routes[0][1]; // 첫번째 끝지점
        for(int i = 1; i<routes.length; i++){
            if(routes[i][0] > end){ // 출발지가 벗어남(카메라 추가)
                answer+=1;
                end = routes[i][1];
            }
        }
        return answer;
    }
}