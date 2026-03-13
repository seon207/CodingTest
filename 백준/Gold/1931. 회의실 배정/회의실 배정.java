import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<conference> list;
    static conference[] conferences;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        conferences = new conference[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            conferences[i] = new conference(start, end);
        }

        // 정렬
        Arrays.sort(conferences);
        list.add(conferences[0]);
        int last = conferences[0].e;    // 끝나는 시간

        for (int i = 1; i < N; i++) {
            if (conferences[i].s >= last) { // 이후에 시작
                list.add(conferences[i]);
                last = conferences[i].e;
            }
        }

        System.out.println(list.size());
    }

    public static class conference implements Comparable<conference> {
        int s;
        int e;

        public conference(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(conference o) {
            return this.e != o.e ? this.e - o.e : this.s - o.s;
        }
    }
}