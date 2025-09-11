import java.util.*;
import java.io.*;


public class Main {
    static long d, x, y, startX, startY, size;
    static String s, answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        d = Long.parseLong(st.nextToken());
        s = st.nextToken();

        st = new StringTokenizer(br.readLine());
        x = Long.parseLong(st.nextToken());
        y = -Long.parseLong(st.nextToken());
        answer = "";

        size = 1L << d;

        startX = 0;
        startY = 0;
        for (int i = 0; i < s.length(); i++) {
            int loc = s.charAt(i) - '0';    // 찾을 사분면
            find(loc);
        }

        // 위치 이동
        startX += x;
        startY += y;

        size = 1L << d;
        // 존재하는 사분면인지 확인
        if (startX < 0 || startY < 0 || startX >= size || startY >= size) {
            System.out.println(-1);
        } else {
            // 이동한 좌표 찾기
            find_cor(size);
            System.out.println(answer);
        }

    }

    // 조각의 위치 찾기
    public static void find(int loc) {
        size /= 2;
        if (loc == 1) { // 1사분면
            startX += size;
        } else if (loc == 3) { // 3사분면
            startY += size;
        } else if (loc == 4) { // 4사분면
            startX += size;
            startY += size;
        }

    }

    public static void find_cor(long size) {
        if (answer.length() == d) return;   // 다 구함
        long nx = startX / (size / 2);
        long ny = startY / (size / 2);

        if (nx == 1 && ny == 0) {   // 1사분면
            answer += "1";
            startX -= (size / 2);
            find_cor(size / 2);
        } else if (nx == 0 && ny == 0) {    // 2사분면
            answer += "2";
            find_cor(size / 2);
        } else if (nx == 0 && ny == 1) {    // 3사분면
            answer += "3";
            startY -= (size / 2);
            find_cor(size / 2);
        } else if (nx == 1 && ny == 1) {    // 4사분면
            answer += "4";
            startX -= (size / 2);
            startY -= (size / 2);
            find_cor(size / 2);
        }
    }
}
