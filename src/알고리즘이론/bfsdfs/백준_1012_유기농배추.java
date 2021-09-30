package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1012_유기농배추 {

    static int M;
    static int N;
    static int K;
    static int[][] map;
    static boolean[][] visited;
    static int cnt;

    static int[] dr = {-1 ,1 , 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc<= T; tc ++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cnt = 0;

            map = new int[N][M];
            visited = new boolean[N][M];

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(in.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                map[r][c] = 1;
            }

            for(int i = 0; i < N; i++) {

                for(int j = 0; j < M; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        dfs(i, j);
                        cnt ++;
                    }
                }

            }
            sb.append(cnt).append("\n");

        }
        System.out.println(sb);

    }

    static void dfs(int r, int c) {

        visited[r][c] = true;

        for(int adj = 0; adj < 4; adj ++) {
            int nr = r + dr[adj];
            int nc = c + dc[adj];

            if(nr < 0 || nc < 0 || nr >= N || nc>= M) continue;
            if(visited[nr][nc]) continue;
            if(map[nr][nc] == 0) continue;
            dfs(nr, nc);
        }

    }
}
