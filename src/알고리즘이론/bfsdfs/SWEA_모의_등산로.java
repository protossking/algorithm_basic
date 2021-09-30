package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_모의_등산로 {

    static int N;
    static int K;
    static int[][] map;
    static boolean[][] visited;
    static int cnt;
    static int max;

    static int ans;

    static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc ++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            ans = 0;

            map = new int[N][N];
            visited = new boolean[N][N];
            max = Integer.MIN_VALUE;

            int high = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    high = Math.max(map[i][j], high);

                }
            }
            ArrayList<Integer> list = new ArrayList<>();
//            System.out.println(high);
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == high) {

                        dfs(i, j, 1, false);

                    }
                }
            }
//            System.out.println(max);
//            System.out.println(ans);
            sb.append("#").append(tc).append(" ").append(ans).append("\n");

        }
        System.out.println(sb);
    }

    private static void dfs(int r,  int c, int cnt, boolean flag) {
        visited[r][c] = true;


//        if(map[r][c] == 1) {
////            System.out.println(cnt);
//            max = Math.max(cnt, max);
////            return;
//        }
        if(ans < cnt) {
            ans = cnt;
        }

        for(int adj = 0; adj < 4; adj ++) {
            int nr = r + delta[adj][0];
            int nc = c + delta[adj][1];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if(visited[nr][nc]) continue;
            if(map[nr][nc] <  map[r][c]) {
                dfs(nr, nc, cnt+1, flag);

            }
            else {
                if(!flag) {
                    if(map[nr][nc] - K < map[r][c]) {
                        int tmp = map[nr][nc];
                        map[nr][nc] = map[r][c] - 1;
                        dfs(nr, nc , cnt+1, true);
                        map[nr][nc] = tmp;
                        flag = false;
                    }
                }

            }
        }
        visited[r][c] = false;
    }
}
