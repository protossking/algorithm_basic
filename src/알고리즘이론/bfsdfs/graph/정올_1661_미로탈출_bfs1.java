package 알고리즘이론.bfsdfs.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 정올_1661_미로탈출_bfs1 {

    static int[][] map;
    static boolean[][] visited;
    private static int x;
    private static int y;
    private static int answer;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int sr, sc, er, ec;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        x = Integer.parseInt(st.nextToken()); // 열
        y = Integer.parseInt(st.nextToken()); // 행
        map = new int[y][x];
        visited = new boolean[y][x];

        st = new StringTokenizer(in.readLine(), " ");
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        er = Integer.parseInt(st.nextToken());
        ec = Integer.parseInt(st.nextToken());

        for (int i = 0; i < y; i++) {
            String[] s = in.readLine().split("");
            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(map[i][j] == 1) {
                    visited[i][j] = true;
                }
            }
        }
        answer = 0;
        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] {sr, sc});
        visited[sr][sc] = true;

        top:
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for(int i = 0; i < 4; i++) {
                int nc = r + dr[i];
                int nr = c + dc[i];

                if(nr > -1 && nr < y && nc > -1 && nc < x && !visited[nr][nc]) {
                    if(nr == er && nc == ec) {
                        System.out.println("정답 " + answer );
                        break top;
                    } else {
                        queue.offer(new int[]{nr , nc});
                        visited[nr][nc] = true;
                        answer++;
                    }
                }
            }
        }
    }

}
