package 알고리즘이론.bfsdfs.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1987_알파벳2 {

    static int R;
    static int C;
    static char map[][];
    static boolean visited[];


    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R+1][C+1];
        visited = new boolean[26];

        for(int i = 1; i <= R; i++) {
            String s = in.readLine();
            for(int j = 1; j <= C; j++) {
                map[i][j] = s.charAt(j-1);
            }
        }

        dfs(1,1, 1);
        System.out.println(max);


    }
    static void dfs(int r, int c, int dist) {

        visited[map[r][c] - 'A'] = true;
        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr > 0 && nr <= R && nc > 0 && nc <= C) {
                if(!visited[map[nr][nc] - 'A']) {
                    dfs(nr ,nc , dist + 1);
                }
            }
        }
        visited[map[r][c] - 'A'] = false;
        max = Math.max(max, dist);



    }
}
