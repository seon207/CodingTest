import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long totalCost, cost;
    static int[] parents;
    static ArrayList<Edge> arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[N + 1];
        parents = new int[N + 1];
        arrayList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            parents[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            totalCost += c;

            arrayList.add(new Edge(a, b, c));
        }

        Collections.sort(arrayList);

        int idx = 0;
        for (int i = 0; i < arrayList.size(); i++) {

            if (idx == N - 1) break;
            Edge e = arrayList.get(i);
            if (union(e.s, e.e)) {
                cost += e.c;
                idx++;
            }
        }


        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (parents[i] == -1) {
                count++;
            }
        }

        if (count > 1) {
            System.out.println(-1);
        } else {
            System.out.println(totalCost - cost);
        }
    }

    public static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;

        parents[rootB] = rootA;
        return true;
    }

    public static int find(int a) {
        if (parents[a] == -1) return a;

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