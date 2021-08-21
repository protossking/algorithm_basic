package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2606_바이러스 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(in.readLine());
        M = Integer.parseInt(in.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
            map[c][r] = 1;
        }
        bfs(1);
        System.out.println(count);

    }

    static void bfs(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(cur);
        visited[cur]= true;

        while (!queue.isEmpty()) {
            cur = queue.poll();

            for(int adj = 1; adj <= N; adj ++) {
                if(map[cur][adj] == 1 && !visited[adj]) {
                    queue.offer(adj);
                    visited[adj] = true;
                    count++;
                }
            }
        }
    }
}
