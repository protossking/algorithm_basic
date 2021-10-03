package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_3184_양 {

    /*
     1. 한 영역을 구하고 양 보다 늑대가 많으면 양은 0
        양이 많으면 늑대가 0
    */

    static int R;
    static int C;
    static char[][] map;
    static boolean[][] visited;

    static int[] dr = {-1, 1 ,0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int wc;
    static int sc;

    static int wAns;
    static int sAns;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        wAns = 0;
        sAns = 0;
        wc = 0;
        sc = 0;

        for (int i = 0; i < R; i++) {
            String s = in.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }

        }

        for(int i = 0; i < R; i++) {
            for(int j =0 ; j < C; j++) {
                if(map[i][j] != '#' && !visited[i][j]) {

                    dfs(i, j);
                    if(sc > wc) {
                        sAns += sc;
                    }
                    else {
                        wAns += wc;
                    }
                    wc = 0;
                    sc = 0;

                }
            }
        }
        System.out.println(sAns +" " + wAns);

    }

    static void dfs(int r , int c) {
        visited[r][c] = true;

        if(map[r][c] == 'v') {
            wc ++;
        }
        if(map[r][c] == 'o') {
            sc ++;
        }

        for(int adj = 0; adj < 4; adj++) {
            int nr = r + dr[adj];
            int nc = c + dc[adj];


            if(nr <0 || nc < 0 || nr >= R || nc >= C)continue;
            if(visited[nr][nc]) continue;
            if(map[nr][nc] != '#') {
                dfs(nr, nc);
            }
        }
    }
}
