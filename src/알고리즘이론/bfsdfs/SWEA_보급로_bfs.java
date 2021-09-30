package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SWEA_보급로_bfs {

    static int N;
    static int[][] map;
    //    static int[][] dis;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(in.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];


            for (int i = 0; i < N; i++) {
                String s = in.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j) - '0';

                }
            }


//            System.out.println(dis[N-1][N-1]);


        }
        System.out.println(sb.toString());


    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];


            for(int adj = 0; adj < 4; adj ++) {
                int nr = r + dr[adj];
                int nc = c + dc[adj];


            }
        }
    }
}
