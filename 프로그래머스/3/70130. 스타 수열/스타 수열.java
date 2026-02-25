import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = -1;
        int[] count = new int[a.length + 1];    // 각 원소가 등장하는 횟수
        for(int i = 0; i < a.length; i++){
            count[a[i]]++;
        }
        
        for(int i = 0; i < count.length; i++){
            if(count[i] == 0 || count[i] <= answer) continue;
            int star = 0;
            for(int j = 0; j < a.length - 1; j++){
                if(a[j] != a[j+1] && (i==a[j] || i==a[j+1])){   // 연속된 두 수가 같지 않고 둘 중 하나가 교집합의 원소
                    j++;
                    star++;
                }
            }
            answer = Math.max(answer, star);
        }
        
        return answer * 2;
    }
}