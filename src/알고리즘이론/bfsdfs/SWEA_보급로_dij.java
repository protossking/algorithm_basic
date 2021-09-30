package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_보급로_dij {

    static int N;
    static int[][] map;
    static int[][] dis;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Point implements Comparable<Point> {

        int r;
        int c;
        int w;

        public Point(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }

        @Override
        public int compareTo(Point o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(in.readLine());
            map = new int[N][N];
            dis = new int[N][N];

            for(int i = 0; i < N; i++) {
                String s = in.readLine();
                for(int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j) - '0';
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }
            dis[0][0] = map[0][0];

            dij();

//            System.out.println(dis[N-1][N-1]);
            sb.append("#").append(tc).append(" ").append(dis[N-1][N-1]).append(" ");



        }
        System.out.println(sb.toString());

    }

    static void dij() {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(0,0, dis[0][0]));




        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            int r = poll.r;
            int c = poll.c;

            for(int adj =0 ; adj < 4; adj ++) {
                int nr = r + dr[adj];
                int nc = c + dc[adj];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if(dis[nr][nc] > dis[r][c] + map[nr][nc]) {
                    dis[nr][nc] = dis[r][c] + map[nr][nc];
                    queue.add(new Point(nr, nc, dis[nr][nc]));
                }

            }
        }
    }

    static int dij(int startR, int startC) {
        boolean[][] visited = new boolean[N][N];
        int[][] minTime = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                minTime[i][j] = Integer.MAX_VALUE;
            }
        }
        minTime[startR][startC] = 0;
        int r = 0, c =0, minCost = 0, nr, nc;
        while (true) {

            //step1
            minCost = Integer.MAX_VALUE;
            for (int i = 0; i <N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j] && minCost > minTime[i][j]) {
                        minCost = minTime[i][j];
                        r = i;
                        c = j;
                    }
                }
            }
            visited[r][c] = true;


            //step2 : 1에서 선택된 정점을 경유지로 해서 인접정점 따져보기

            for(int d = 0; d < 4; d++) {
                nr = r + dr[d];
                nc = r + dc[d];

                if(nr>=0 && nr < N && nc>=0 && nc< N && !visited[nr][nc] && minTime[nr][nc] > minCost + map[nr][nc]) {
                    minTime[nr][nc] = minCost + map[nr][nc];
                }
            }
        }
    }
}
