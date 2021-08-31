import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main2 {

    static int[][] map;
    static int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dc = {0, 0, -1, 1, -1, -1, 1, 1};
    static int N;
    static int M;
    static int black;
    static int white;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            N = Integer.parseInt(st.nextToken()); // n 은 판크기
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            black = 0;
            white = 0;

            if (N == 4) {
                map[1][1] = 2;
                map[1][1] = 2;
                map[1][2] = 1;
                map[2][1] = 1;
            }
            if (N == 6) {
                map[2][2] = 2;
                map[3][3] = 2;
                map[2][3] = 1;
                map[3][2] = 1;
            }
            if (N == 8) {
                map[3][3] = 2;
                map[4][4] = 2;
                map[3][4] = 1;
                map[4][3] = 1;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                int c = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;
                map[r][c] = Integer.parseInt(st.nextToken());

                for (int j = 0; j < 8; j++) {
                    int nc = c + dc[j];
                    int nr = r + dr[j];

                    while (true) {
                        if (!isIn(nr, nc) && map[nr][nc] == 0) {
                            break;
                        }
                        if (map[nr][nc] != map[r][nc]) {
                            nr += dr[j];
                            nc += dc[j];
                        } else {
                            break;
                        }
                    }
                    if (isIn(nr, nc) && map[nr][nc] == map[r][c]) {
                        while (nr != r || nc != c) {
                            map[nr][nc] = map[r][c];
                            nr -= dr[j];
                            nc -= dc[j];
                        }
                    }


                }

            }



        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    black++;
                }
                if(map[i][j] == 2) {
                    white++;
                }
            }
        }

    }



    static boolean isIn(int r, int c) {
        if (r > -1 && c > -1 && r < N && c < N) {
            return true;
        }
        return false;
    }
}
