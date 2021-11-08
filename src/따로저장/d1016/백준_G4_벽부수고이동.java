package 따로저장.d1016;

import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_G4_벽부수고이동 {

    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    static int min;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int count;
    static int ans;

    static int[][] map2;

    static int[][] walls;
    static int cc;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        walls = new int[N * M][2];
        map2= new int[N][M];
        count = 0;
        cc =0;


        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1) {
                    walls[cc][0] = i;
                    walls[cc][1] = j;
                    cc ++;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            String s = in.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) -'0';
            }
        }
        // 벽을 안 없을 떄의 최단 거리
        min = Integer.MAX_VALUE;
        bfs();
        System.out.println(map2[N-1][M-1]);
        System.out.println(min);
        System.out.println(ans);
        visited = new boolean[N][M];
        combi(0, 0);
        bfs();
        System.out.println(min);


    }

   static void bfs() {
       Queue<int[]> queue = new LinkedList<>();
       queue.offer(new int[]{0, 0});
       visited[0][0] = true;

       while (!queue.isEmpty()) {
           int[] cur = queue.poll();
           int r = cur[0];
           int c = cur[1];

           for(int adj = 0; adj < 4; adj ++) {
               int nr = r + dr[adj];
               int nc = c + dc[adj];

               if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
               if(visited[nr][nc]) continue;
               if(map[nr][nc] != 0) continue;
               visited[nr][nc] = true;
               queue.offer(new int[]{nr ,nc});
               map2[nr][nc] = map2[r][c] + 1;
           }
       }
       min = Math.min(min , map2[N-1][M-1]);

   }

    static void combi(int cnt, int start) {
        if(cnt == 1) {
            bfs();
            return;
        }
        if(start >= N * M) {
            return;
        }


        map[walls[start][0]][walls[start][1]] = 0;
        combi(cnt + 1, start + 1);
        map[walls[start][0]][walls[start][1]] = 1;
        combi(cnt, start + 1);
    }
}
