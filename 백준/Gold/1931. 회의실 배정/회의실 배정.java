import java.io.*;
import java.util.*;

public class Main {
    public static class Edge implements Comparable<Edge> {
        int s;
        int e;

        public Edge(int s, int e) {
            this.s = s;
            this.e = e;

        }

        @Override
        public int compareTo(Edge o) {
            return this.e != o.e ? this.e - o.e : this.s - o.s;
        }
    }

    static int N;
    static ArrayList<Edge> list;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            Edge edge = new Edge(s, e);
            list.add(edge);
        }

        Collections.sort(list);

        Edge front = list.get(0);   // 제일 처음
        count = 1;
        for (int i = 1; i < N; i++) {
            if (front.e <= list.get(i).s) {
                front = list.get(i);
                count++;
            }
        }

        System.out.println(count);
    }
}