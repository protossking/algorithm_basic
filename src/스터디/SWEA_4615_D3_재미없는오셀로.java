package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4615_D3_재미없는오셀로 {
    static int[][] map;

    static int N;
    static int M;
    static int black;
    static int white;
    //좌상 우하 우상 좌하
    static int[] dr = {-1, 1 ,0 ,0, -1, 1, -1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(src));
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(in.readLine());

        for(int tc=1 ; tc <= T; tc++) {
            st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            black = 0;
            white = 0;
            if(N == 4) {
                map[1][1] = 2;
                map[2][2] = 2;
                map[1][2] = 1;
                map[2][1] = 1;
            }
            if(N == 6) {
                map[2][2] = 2;
                map[3][3] = 2;
                map[2][3] = 1;
                map[3][2] = 1;
            }
            if(N == 8) {
                map[3][3] = 2;
                map[4][4] = 2;
                map[3][4] = 1;
                map[4][3] = 1;
            }

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                int c = Integer.parseInt(st.nextToken()) -1;
                int r = Integer.parseInt(st.nextToken()) -1;

                map[r][c] = Integer.parseInt(st.nextToken());
                for(int adj = 0; adj < 8; adj++) {

                    int nr = r + dr[adj];
                    int nc = c + dc[adj];

                    while(true) {
                        if(!isIn(nr, nc) || map[nr][nc] == 0) {
                            break;
                        }
                        if(map[r][c] != map[nr][nc]) {
                            nr += dr[adj];
                            nc += dc[adj];
                        }else {
                            break;
                        }
                    }
                    if(isIn(nr,nc) && map[nr][nc] == map[r][c]) {
                        while(r != nr || c != nc) {
                            map[nr][nc] = map[r][c];
                            nr -= dr[adj];
                            nc -= dc[adj];
                        }
                    }
                }


            }
            System.out.println(Arrays.deepToString(map));
            for(int i =0 ; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == 1) {
                        black++;
                    } else if(map[i][j] == 2) {
                        white ++;
                    }
                }
            }
            System.out.printf("#%d %d %d\n", tc, black,white);
        }
    }


    static boolean isIn(int r, int c) {
        if(r > -1 && r < N && c > -1 && c < N) {
            return true;
        }
        return false;
    }



    static String src ="1\n" +
            "4 12\n" +
            "1 2 1\n" +
            "1 1 2\n" +
            "4 3 1\n" +
            "4 4 2\n" +
            "2 1 1\n" +
            "4 2 2\n" +
            "3 4 1\n" +
            "1 3 2\n" +
            "2 4 1\n" +
            "1 4 2\n" +
            "4 1 2\n" +
            "3 1 2";
}
