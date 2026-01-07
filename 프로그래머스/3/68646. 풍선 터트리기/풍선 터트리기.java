import java.util.*;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        if (n <= 2) return n;

        // 왼쪽 최소
        int[] leftMin = new int[n];
        leftMin[0] = a[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }

        // 오른쪽 최소
        int[] rightMin = new int[n];
        rightMin[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
                answer++;
            }
        }
        return answer;
    }
}