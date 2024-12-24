import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] point;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        point = new int[3][2];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        int val = (point[1][0] - point[0][0]) * (point[2][1] - point[0][1]) - (point[2][0] - point[0][0]) * (point[1][1] - point[0][1]);

        if (val == 0) {   // 일직선
            System.out.println(0);
        } else if (val < 0) {   // 시계
            System.out.println(-1);
        } else { // 반시계
            System.out.println(1);
        }
    }
}
