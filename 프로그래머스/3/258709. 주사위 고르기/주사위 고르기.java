import java.io.*;
import java.util.*;

class Solution {
    static int N, max;
    static boolean[] visited;
    static int[][] dices;
    static int[] answer;
    public int[] solution(int[][] dice) {
        N = dice.length;
        visited = new boolean[N];
        dices = dice.clone();
        max = -1;
        
        answer = new int[N/2];
        comb(0,0);
        
        return answer;
    }
    
    // 주사위 선택
    public static void comb(int depth, int idx){
        if(depth == N/2){ // 모두 선택
            roll();
            return;
        }
        
        for(int i = idx; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                comb(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
    
    // 주사위 굴리기
    public static void roll(){
        
        List<Integer> aDice = new ArrayList<>();
        List<Integer> bDice = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (visited[i]) aDice.add(i);
            else bDice.add(i);
        }
        
        ArrayList<Integer> aSums = new ArrayList<>();
        ArrayList<Integer> bSums = new ArrayList<>();
        
        makeSum(aDice, 0, 0, aSums);
        makeSum(bDice, 0, 0, bSums);

        Collections.sort(bSums);
        
        int aWin = 0;
        // a보다 작은 개수
        for (int a : aSums) {
            aWin += find(bSums, a);
        }

        // 더 많이 이길 수 있는 경우
        if (aWin > max) {
            max = aWin;
            int idx = 0;
            for(int num : aDice){
                answer[idx++] = num + 1;
            }
            // for (int i = 0; i < N; i++) {
            //     if (visited[i]) {
            //         answer[idx++] = i + 1;
            //     }
            // }
        }
    }
    
    public static void makeSum(List<Integer> dice, int depth, int sum, ArrayList<Integer> sums){
        if(depth == N/2){
           sums.add(sum);
            return;
        }
        
        int idx = dice.get(depth);
        for (int i = 0; i < 6; i++) {
            makeSum(dice, depth + 1, sum + dices[idx][i], sums);
        }
    }
    
    // 더 작은 수 찾기
    public static int find(ArrayList<Integer> list, int num) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < num) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}