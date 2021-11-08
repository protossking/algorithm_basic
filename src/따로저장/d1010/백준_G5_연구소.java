package 따로저장.d1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_G5_연구소 {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int wall;
    static int ans;
    static int[][] walls;


    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];



        for(int i = 0 ; i < N; i++) {
             st = new StringTokenizer(in.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        walls = new int[N*M][2];
        wall = 0;
        ans = Integer.MIN_VALUE;


        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {

                    walls[wall][0] = i;
                    walls[wall][1] = j;
                    wall++;
                }
            }
        }


        dfs(0, 0);
        System.out.println(ans);


    }
    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
//        for(int i = 0; i < N; i++) {
//            for(int j = 0; j < M; j++) {
//                visited[i][j] = false;
//            }
//        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
//                visited[i][j] = false;
                if(map[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()) {

            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for(int adj = 0; adj < 4; adj ++) {
                int nr = r + dr[adj];
                int nc = c + dc[adj];
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] != 0 ) continue;
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0 &&  !visited[i][j]) {
                    cnt++;

                }
            }
        }

        ans = Math.max(ans, cnt);


    }
    static void dfs(int depth, int start) {
        if(depth == 3) {

            bfs();
            return;
        }
        if(start >= wall) return;

        map[walls[start][0]][walls[start][1]] = 1;
        dfs(depth+1, start + 1);

        map[walls[start][0]][walls[start][1]] = 0;
        dfs(depth, start+1);
    }
}



