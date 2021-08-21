package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_3109_빵집 {

    static int R;
    static int C;
    static char[][] map;

    static int pipe;    // 우상 우 우하
//    static int[] dr = {0, -1, 1};
//    static int[] dr = {-1, 0, 1};
    static int[] dr ={-1, 0, 1};
    static int[] dc = {1, 1, 1};



    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for(int i = 0; i < R; i++) {
            String s = in.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        pipe = 0;
        for(int i = 0; i < R; i++) {
            dfs(i,0);
        }
        System.out.println(pipe);
    }
    static boolean dfs(int r, int c) {
        if(c == C-1) {
            pipe++;
            return true;
        }

        for(int i = 0; i < 3; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(isIn(nr, nc) && map[nr][nc] == '.') {
                map[r][c] = 'x';
                if(dfs(nr,nc)) {

                    return true;
                }
            }
        }
        return false;


    }
    static boolean isIn(int r, int c) {
        if(r > -1 && r < R && c > -1 && c < C) {
            return true;
        }
        return false;
    }
}
