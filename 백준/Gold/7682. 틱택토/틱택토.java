import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String game = br.readLine();
            if (game.equals("end")) break;

            board = new char[3][3];
            int xcount = 0, ocount = 0, idx = 0;

            // 보드 입력 및 개수 세기
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = game.charAt(idx++);
                    if (board[i][j] == 'X') xcount++;
                    else if (board[i][j] == 'O') ocount++;
                }
            }

            boolean xWin = isWin('X');
            boolean oWin = isWin('O');

            // x 승리 확인
            if (xcount == ocount + 1) {
                if (xcount + ocount == 9 && !isWin('O')) {
                    sb.append("valid").append("\n");
                } else if (!isWin('O') && isWin('X')) {
                    sb.append("valid").append("\n");
                } else {
                    sb.append("invalid").append("\n");
                }
            } else if (xcount == ocount) {  // o 승리 확인
                if (!isWin('X') && isWin('O')) {
                    sb.append("valid").append("\n");
                } else {
                    sb.append("invalid").append("\n");
                }
            } else {
                sb.append("invalid").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean isWin(char mark) {
        // 가로 확인
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == mark && board[i][1] == mark && board[i][2] == mark) {
                return true;
            }
        }
        // 세로 확인
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == mark && board[1][j] == mark && board[2][j] == mark) {
                return true;
            }
        }
        // 대각선 확인
        if (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) return true;
        if (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark) return true;

        return false;
    }
}