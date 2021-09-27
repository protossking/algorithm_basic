package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_7576_토마토 {

    static int M;
    static int N;
    static int[][] map;

    static int[] dr = {-1, 1 , 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static Queue<int[]> queue = new LinkedList<>();





    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];





        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        System.out.println(bfs());


    }

    static int bfs() {

        while(!queue.isEmpty()) {

            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for(int adj = 0; adj < 4; adj ++) {
                int nr = r + dr[adj];
                int nc = c + dc[adj];

                if(nr > -1 && nc > -1 && nr < N && nc < M) {
                    if(map[nr][nc] == 0) {
//                        map[nr][nc] = 1;
                        queue.offer(new int[]{nr, nc});
                        map[nr][nc] = map[r][c] + 1;


                    }
                }

            }

        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    return -1;
                }else {
                    ans = Math.max(ans, map[i][j]);
                }
            }
        }
        return ans-1;


    }





}
