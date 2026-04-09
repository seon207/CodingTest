import java.io.*;
import java.util.*;

public class Main {
    static int N, count;
    static ArrayList<C> list;

    public static class C implements Comparable<C> {
        int s;
        int e;

        public C(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(C o) {
            return this.s == o.s ? this.e - o.e : this.s - o.s;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            C c = new C(start, end);
            list.add(c);
        }

        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(list.get(0).e);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= list.get(i).s) {
                pq.poll();
            }
            pq.offer(list.get(i).e);
        }
        System.out.println(pq.size());
    }
}