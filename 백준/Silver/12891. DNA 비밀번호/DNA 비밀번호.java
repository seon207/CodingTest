import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int S;   // 임의의 문자열 길이
    static int P;   // 부분문자열 길이
    static int[] contains; // 최소 개수를 담고 있는 배열
    static int[] current; // 현재 윈도우 내 각 문자의 개수를 담는 배열
    static int validCount; // 조건을 만족하는 문자들의 개수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        String s = br.readLine();   //임시 비밀번호
        contains = new int[4];  //최소 문자 수
        current = new int[4];   //현재 가지고 있는 값 저장
        validCount = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            contains[i] = Integer.parseInt(st.nextToken()); //최소 문자 수 저장
            if (contains[i] == 0) validCount++; // 처음부터 조건을 만족하는 경우 고려
        }

        // 첫 번째 윈도우 설정
        for (int i = 0; i < P; i++) {
            add(s.charAt(i));
        }

        int count = 0;
        if (validCount == 4) {
            count++;
        }

        // 슬라이딩 윈도우 시작
        for (int i = P; i < S; i++) {
            add(s.charAt(i));           // 새로운 문자
            remove(s.charAt(i - P));    // 첫번째 문자 제거
            if (validCount == 4) {
                count++;
            }
        }

        System.out.println(count);
    }

    // getindex로 인덱스 받아와서 해당되는 배열값 +1
    public static void add(char c) {
        int index = getIndex(c);
        current[index]++;
        if (current[index] == contains[index]) {    // 최소 개수에 도달했을 때
            validCount++;
        }
    }

    // 문자 제거
    public static void remove(char c) {
        int index = getIndex(c);
        if (current[index] == contains[index]) {    // 제거로 인해 조건을 만족하지 않게 될 때
            validCount--;
        }
        current[index]--;
    }

    // index 찾기
    public static int getIndex(char c) {
        if (c == 'A') return 0;
        if (c == 'C') return 1;
        if (c == 'G') return 2;
        return 3;   // T일 때
    }
}
