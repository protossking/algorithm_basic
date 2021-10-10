package 따로저장.d1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_S1_영역구하기 {

    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1 ,0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int R;
    static int C;
    static int K;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(in.readLine());
            int sc = Integer.parseInt(st.nextToken());
            int sr = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());
            square(sc,sr,ec,er);
        }
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == 0 && !visited[i][j]) {
                    cnt = 0;
                    dfs(i,j);
                    list.add(cnt);

                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i : list) {
            System.out.print(i+ " ");
        }



    }

    static void dfs(int r, int c) {
        visited[r][c] = true;
        cnt ++;

        for(int adj = 0; adj < 4; adj++) {
            int nr = r + dr[adj];
            int nc = c + dc[adj];
            if(nr < 0 || nc < 0 || nr>= R || nc >= C) continue;
            if(visited[nr][nc]) continue;
            if(map[nr][nc] != 0) continue;
            dfs(nr, nc);
        }
    }
                        // 0   2      4       4
    static void square(int sc, int sr, int ec, int er) {
        // 사각형 좌표는 열 부터 입력
        for(int i = sc; i < ec; i++) {
            for(int j = sr; j < er; j++) {
                map[j][i] = 1;
            }
        }

    }
}


/*
 모눈 종이 채우고
 sr sc er ec 부분 다 채우고
 */