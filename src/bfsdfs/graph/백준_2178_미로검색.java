package bfsdfs.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2178_미로검색 {

    static int map[][];
    static int N;
    static int M;
    static boolean visited[][];
    static int cnt;
    static int[] dr = {-1,1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int sr;
    static int sc;
    static int er;
    static int ec;


    public static void main(String[] args) throws Exception{

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        sr = 0;
        sc = 0;
        er = N-1;
        ec = M-1;

        for(int i =0; i < N; i++) {
             String s = in.readLine();
             for(int j = 0; j < M; j++) {
                 map[i][j] = s.charAt(j) - '0';
             }

        }


        cnt = 0;
        bfs();


    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr,sc, 0});
        visited[sr][sc] = true;

        top:
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            cnt = cur[2] + 1;

            for(int adj = 0; adj < 4; adj ++) {
                int nr = r + dr[adj];
                int nc = c + dc[adj];
                if(nr > -1 && nr < N && nc > -1 && nc < M && !visited[nr][nc] && map[nr][nc] == 1) {
                    if(nr == er  && nc == ec) {
                        System.out.println("도착" + er + " " + ec);
                        System.out.println(cnt + 1);
                        break top;
                    }else {
                        queue.offer(new int[]{nr, nc, cnt});
                        visited[nr][nc] = true;

                    }
                }
            }
        }

    }

}