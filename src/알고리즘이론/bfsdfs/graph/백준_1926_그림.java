package 알고리즘이론.bfsdfs.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1926_그림 {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    static int cnt;
    static int area;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = 0;
        area = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0 || visited[i][j]) {
                    continue;
                }


                    bfs(i, j);


            }
        }


            System.out.println(cnt);
            System.out.println(max);





    }
    static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        cnt ++;
        area = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            area ++;
            for(int adj = 0; adj < 4; adj++) {
                int nr = r + dr[adj];
                int nc = c + dc[adj];

                if(nr > -1 && nr < N && nc > -1 && nc < M) {
                    if(map[nr][nc] == 1 && !visited[nr][nc]) {
                        q.offer(new int[]{nr , nc});
                        visited[nr][nc] = true;


                    }
                }
//                if(nr <0 || nr >= N || nc < 0 || nc >= M) continue;
//                if(map[nr][nc] == 1 && !visited[nr][nc]) {
//                    q.offer(new int[]{nr, nc});
//                    visited[nr][nc] = true;
//                }
//
            }
        }
        if(area >= max) {
            max = area;
        }

    }

}
