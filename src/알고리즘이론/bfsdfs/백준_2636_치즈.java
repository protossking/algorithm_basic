package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2636_치즈 {

    static int[][] map;
    static int N;
    static int M;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

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



        int cnt = 0;
        int time = 0;
        while(true) {
            cnt = 0;
            bfs();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] == 2) {
                        cnt ++;
                    }
                }
            }
            if(check(map)) {
                break;
            }
            remove(map);
            time ++;
            for(int i = 0; i < visited.length; i++) {
                Arrays.fill(visited[i], false);
            }

        }
        System.out.println(time + 1);
        System.out.println(cnt);





    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for(int adj = 0 ; adj < 4; adj ++) {
                int nr = r + dr[adj];
                int nc = c + dc[adj];

                if(nr > -1 && nc > -1 && nr < N && nc < M && !visited[nr][nc]) {
                    if(map[nr][nc] == 1) {
                        map[nr][nc] = 2;
                        visited[nr][nc] = true;
                    }else {
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }

    }

    static void remove(int[][] map) {
        for(int i = 0; i <N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 2){
                    map[i][j] = 0;

                }
            }
        }
    }
    static boolean check(int[][] map) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
