package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_11724_연결요소의개수 {

    static int n;
    static int m;
    static int[][] map;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n];
        cnt = 0;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            map[r][c] = 1;
            map[c][r] = 1;
        }
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            cnt++;
            dfs(i);

        }
        System.out.println(cnt);


    }

    private static void dfs(int cur) {
        visited[cur] = true;



        for(int i = 0; i < n; i++) { //
            if(!visited[i] && map[cur][i] == 1) {
                dfs(i);


            }
        }

    }
}
