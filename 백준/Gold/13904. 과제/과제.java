import java.io.*;
import java.util.*;

public class Main {
    static int N, maxDay, score;
    static ArrayList<Work> arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arrayList = new ArrayList<>();
        maxDay = 0;
        score = 0;

        // 저장
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            maxDay = Math.max(d, maxDay);
            arrayList.add(new Work(d, w));
        }


        for (int i = maxDay; i > 0; i--) {
            int idx = findWork(i);
            if (idx == -1) {
                continue;
            }
            score += arrayList.get(idx).w;
            arrayList.remove(idx);
        }

        System.out.println(score);
    }

    // 현재 일수보다 적은 일수만 가능
    public static int findWork(int day) {
        int s = 0;  // 과제 점수
        int result = -1;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).d >= day && arrayList.get(i).w >= s) {
                result = i;
                s = arrayList.get(i).w;
            }
        }

        return result;
    }

    public static class Work {
        int d;
        int w;

        public Work(int d, int w) {
            this.d = d;
            this.w = w;
        }
    }
}