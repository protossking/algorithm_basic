package 따로저장.d1110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_봄버맨 {

    static int R;
    static int C;
    static char[][] map;
    static boolean[][] visited;
    static int T;
    static Queue<int[]> queue = new LinkedList<>();

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            String s = in.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }
//        System.out.println(Arrays.deepToString(map));
        int t = 1;
        while(true) {

            if(t == T) {
                break;
            }

            t++;
            s2(); // 폭탄 채우기
            if(t == T) {
                break;
            }
            t++;
            s3(); // 폭탄 폭발

            if(t == T) {
                break;
            }



        }
        for(int i = 0; i < R; i++) {

            for(int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }


    }

    //2초때 모든 칸에 폭탄 설치

    static void s2() {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == '.') {
                    map[i][j] = 'O';
                }else { // O 인값
                    queue.offer(new int[]{i, j});
                }
            }
        }
    }
    //3초때 설치된 폭탄 폭발
    static void s3() {

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            map[r][c] = '.';

            for(int adj = 0; adj < 4; adj++) {
                int nr = r + dr[adj];
                int nc = c + dc[adj];

                if(!isIn(nr, nc)) continue;
                map[nr][nc] = '.';

            }
        }
    }

    static boolean isIn(int r, int c) {
        if(r < 0 || c < 0 || r >= R || c>= C) {
            return false;
        }
        return true;
    }
}
