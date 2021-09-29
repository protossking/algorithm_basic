package 알고리즘이론.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_4485_젤다 {

    static int[][] map;
    static int[][] dis;
    static boolean[][] visited;
    static int N;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

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
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while(true) {
            count ++;
            N = Integer.parseInt(in.readLine());
            if(N == 0) break;


            map = new int[N][N];
            dis = new int[N][N];
            visited = new boolean[N][N];


            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }

            dis[0][0] = map[0][0];

            PriorityQueue<Point> queue = new PriorityQueue<>();
            queue.add(new Point(0, 0, map[0][0]));


            while (!queue.isEmpty()) {
                Point poll = queue.poll();
                int r = poll.r;
                int c = poll.c;


                for(int adj = 0; adj < 4; adj ++) {
                    int nr = r + delta[adj][0];
                    int nc = c + delta[adj][1];

                    if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                    if(dis[nr][nc] > dis[r][c] + map[nr][nc]) {
                        dis[nr][nc] = dis[r][c] + map[nr][nc];
                        queue.add(new Point(nr, nc, dis[nr][nc]));
                    }
                }
            }
//            System.out.println(dis[N-1][N-1]);
            sb.append("Problem ").append(count).append(":").append(" ").append(dis[N-1][N-1]).append("\n");

        }
        System.out.println(sb.toString());


    }
}
