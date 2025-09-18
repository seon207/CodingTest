import java.io.*;
import java.util.*;

public class Main {
    static int N, M, t;
    static long cost;

    static int[] parents;
    static ArrayList<Edge> arrayList, first;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList<>();
        first = new ArrayList<>();
        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parents[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (s == 1) {
                first.add(new Edge(s, e, c));
            } else {
                arrayList.add(new Edge(s, e, c));
            }
        }

        Collections.sort(first);
        Edge e = first.get(0);
        arrayList.addAll(first);

        ArrayList<Edge> list = new ArrayList<>();
        list.add(e);
        Collections.sort(arrayList);
        list.addAll(arrayList);


        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            Edge edge = list.get(i);

            if (union(edge.s, edge.e)) {
                cost += edge.c;
                idx++;

                if (idx > 1) {
                    cost += (t * (idx - 1));
                }
            }
        }

        System.out.println(cost);
    }

    public static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return false;
        }

        parents[rootB] = rootA;
        return true;
    }

    public static int find(int a) {
        if (parents[a] == -1) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    public static class Edge implements Comparable<Edge> {

        int s;
        int e;
        int c;

        public Edge(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }
    }
}