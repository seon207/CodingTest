import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static String first, king;
    static Map<String, Parent> parent; // 부모
    static Map<String, Double> family; // 혈통

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        parent = new HashMap<>();
        family = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        first = br.readLine();
        family.put(first, 1d);   // 처음 시작

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String dad = st.nextToken();
            String mom = st.nextToken();

            parent.put(child, new Parent(dad, mom));

            family.put(child, -1d);
            family.put(dad, -1d);
            family.put(mom, -1d);
        }

        // 혈통 계산
        for (String c : family.keySet()) {
            find(c);
        }

        king = br.readLine();
        double max = family.get(king);
        for (int i = 0; i < M - 1; i++) {
            String s = br.readLine();

            if (family.getOrDefault(s, -1d) > max) {
                max = family.get(s);
                king = s;
            }
        }

        System.out.println(king);

    }

    //정보 구하기
    public static double find(String child) {
        // 없을 때 -> 추가
        if (!parent.containsKey(child)) {
            if (child.equals(first)) {  // 나라 세운 사람
                family.put(child, 1d);
                return 1;
            } else {
                family.put(child, 0d);
                return 0;
            }
        }

        // 연결됐을 때
        if (family.get(child) != -1) {
            return family.get(child);
        }

        double dad = find(parent.get(child).f);
        double mom = find(parent.get(child).m);

        //혈통
        family.put(child, (dad + mom) / 2);

        return family.get(child);
    }

    static class Parent {
        String f;
        String m;

        public Parent(String f, String m) {
            this.f = f;
            this.m = m;
        }
    }
}