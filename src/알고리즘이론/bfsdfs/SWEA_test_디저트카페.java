package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_test_디저트카페 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1, 1, -1, -1}; // 우하 하좌 상좌 상우
    static int[] dc = {1, -1, -1, 1};
    static int max;
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        for(int tc = 1; tc<= T; tc++) {
            N = Integer.parseInt(in.readLine());
            max = Integer.MIN_VALUE;
            count = 0;

            map = new int[N][N];
            visited = new boolean[N][N];

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    dfs(i, j, i, j);
                }
            }
            visited = new boolean[N][N];
        }
    }

    static void dfs(int r, int c, int s, int e) {
        visited[r][c] = true;

        for(int adj = 0; adj < 4; adj ++) {
            adj = adj % 4;
            int nr = r + dr[adj];
            int nc = c = dc[adj];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if(visited[nr][nc]) continue;
            if(s == nr && e == nc) {
                max = Math.max(count, max);
                return;
            }


        }
    }
}
