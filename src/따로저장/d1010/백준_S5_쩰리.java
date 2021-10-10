package 따로저장.d1010;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_S5_쩰리 {

    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int[] dr = {1, 0};
    static int[] dc = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0);
        if (visited[N - 1][N - 1]) {
            System.out.println("HaruHaru");
        }
        if (!visited[N - 1][N - 1]) {
            System.out.println("Hing");
        }

    }

    static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        top:
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int l = map[r][c];
            for (int adj = 0; adj < 2; adj++) {

                int nr = r + dr[adj] * l;
                int nc = c + dc[adj] * l;
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (visited[nr][nc]) continue;
                queue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
                if(map[nr][nc] == -1) {
                    break top;
                }

            }
        }
    }
}
