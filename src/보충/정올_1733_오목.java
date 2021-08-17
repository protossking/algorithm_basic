package 보충;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 정올_1733_오목 {

    static int[][] map;
    static boolean[][] visited;
                    //상하좌우 좌상 좌하 우상 우하
    static int[] dr = {-1, 1, 0 ,0, -1, 1, -1, 1};
    static int[] dc = {0, 0, -1, 1, -1, -1 ,1, 1};
    // 검은거 1 흰거 2 알 없는거 0
    static int bcnt;
    static int wcnt;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        map = new int[19][19];
        visited = new boolean[19][19];
        bcnt = 0 ;
        wcnt = 0;

        for(int i =0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < 19; i++) {
            for(int j = 0; j < 19; j++) {
                if(map[i][j] == 0 | visited[i][j] ) continue;
                    bfs(i , j);
            }
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


            for(int dir=0; dir < 8; dir ++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if(nr > -1 && nr < 19 && nc > -1 && nc < 19 && !visited[nr][nc]) {
                    if(map[nr][nc] == 1) {
                        //검
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                        bcnt++;

                    }
                    if(map[nr][nc] == 2) {
                        //흰
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                        wcnt++;
                    }

                }
            }
            if(bcnt == 5) {
                System.out.println(bcnt);
                System.out.println("검은돌이김 ");
                break top;
            }
            else if(wcnt == 5) {
                System.out.println(wcnt);
                System.out.println("흰돌 이김 ");
                break top;
            } else {
                System.out.println("무승부 ");
                break top;
            }



        }
    }
}
