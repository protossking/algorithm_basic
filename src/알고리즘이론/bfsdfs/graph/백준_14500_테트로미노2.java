package 알고리즘이론.bfsdfs.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14500_테트로미노2 {

    static int[][] map;

    static int[] dr = {-1, 1 , 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N;
    static int M;
    static int max;
    static boolean[][] visited;



    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        map = new int[N][M];
        max = Integer.MIN_VALUE;
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0 ; i < N; i++) {
            for(int j = 0; j < M; j++) {
                dfs(i,j, 0 , 0);
                ff(i,j);
            }
        }
        System.out.println(max);


    }
    public static void dfs(int r, int c, int cnt, int sum) {
        if(cnt == 4) {
            max = Math.max(sum , max);
            return;
        }

        for(int adj = 0; adj <4; adj++) {
            int nr = r + dr[adj];
            int nc = c + dc[adj];

            if(nr > -1 && nr < N && nc > -1 && nc < M && !visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr, nc, cnt + 1, sum + map[nr][nc]);
                visited[nr][nc] = false;
            }

        }



    }
    static void ff (int r, int c) {

        if(r + 2 < N && c + 1 < M) { // ㅏ
            max = Math.max(max, map[r][c] + map[r+1][c] + map[r+2][c] + map[r+1][c+1]);
        }
        if(r + 2 < N &&  c  > 0) { // ㅓ
            max = Math.max(max, map[r][c] + map[r+2][c] + map[r+1][c] + map[r+1][c-1]);
        }
        if(r > 0 && c + 2 < M) { //ㅗ
            max = Math.max(max, map[r][c] + map[r][c+2] + map[r-1][c+1] + map[r][c+1]);
        }
        if(c+2 < M && r +1< N) { //  ㅜ
            max = Math.max(max, map[r][c] + map[r][c+1] + map[r][c+2] + map[r+1][c+1]);
        }
    }


}
