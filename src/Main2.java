import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main2 {

    static int n;
    static int m;
    static int[][] map;
    static int d;
    static int[][] delta = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; //북 서 남 동

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        st = new StringTokenizer(in.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int k = d;
//        k = k + 1;
        while (true) {
            // 청소
            map[r][c] = 2;

            // 방향입력받아 돌리기

            int nr = r + delta[k % 3][0];
            int nc = c + delta[k % 3][1];

            if (isIn(nr, nc)) {

                if (map[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    map[nr][nc] = 2;
                    continue;


                }
                else if(map[nr][nc] == 1 || map[nr][nc] == 2) {
                    boolean flag = false;

                    for(int i =0 ; i < 4; i++) {
                        int a = r + delta[i][0];
                        int b = c + delta[i][1];

                        if(map[a][b] != 0) {
                            flag = true;
                        } else {
                            flag = false;
                            break;
                        }
                    }

                    if(flag) {
                        int a = r - delta[k%3][0];
                        int b = c - delta[k%3][1];
                        if(map[a][b] == 1) {
                            break;
                        } else {
                            r = a;
                            c = b;
                            continue;
                        }
                    } else {
                        k ++;
                        continue;
                    }
                }

            }






        }

        int cnt = 0;
        for (
                int i = 0;
                i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static boolean isIn(int r, int c) {
        if (r < 0 || c < 0 || r >= n || c >= m) {
            return false;
        }
        return true;
    }

    static boolean all(int r, int c) {
        if (map[r - 1][c] == 0 || map[r][c - 1] == 0 || map[r + 1][c] == 0 || map[r][c + 1] == 0) {
            return false;
        }

        return true;
    }


    static int rotate(int dir) {

        // 북쪽이면 서쪽으로
        if (dir == 0) {
            return 2;
        }

        // 서쪽이면 남쪽으로
        else if (dir == 1) {
            return 1;
        }

        // 남쪽이면 동쪽으로
        else if (dir == 2) {
            return 3;
        }
        // 동쪽이면 북쪽으로
        else {
            return 0;
        }
    }

}
