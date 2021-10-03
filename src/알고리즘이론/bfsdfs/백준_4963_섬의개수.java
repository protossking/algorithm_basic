package 알고리즘이론.bfsdfs;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_4963_섬의개수 {

    static int C;
    static int R;
    static int[][] map;
    static boolean[][] visited;
    static int cnt;

    static int[] dr = {-1, 1 , 0, 0, -1, -1, 1, 1}; //상하좌우 좌상 우상 좌하 우하
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1}; //상하좌우 좌상 우상 좌하 우하

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();


        while (true) {


            StringTokenizer st = new StringTokenizer(in.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            map = new int[R][C];
            visited = new boolean[R][C];
            cnt = 0;

            if(R == 0 && C == 0) {
                break;
            }


            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < C; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                        cnt ++;
                    }
                }
            }
            sb.append(cnt).append("\n");


        }
        System.out.println(sb.toString());





    }

    static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for(int adj = 0; adj < 8; adj ++) {
                int nr = r + dr[adj];
                int nc = c + dc[adj];

                if(nr <0 || nc <0 || nr >= R || nc >= C)continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] != 1) continue;

                queue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}
