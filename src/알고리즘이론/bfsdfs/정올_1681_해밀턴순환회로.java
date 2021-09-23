package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정올_1681_해밀턴순환회로 {
    static int N;
    static int[][] map;
    static boolean[] visited;

    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine().trim());

        map = new int[N][N];
        visited = new boolean[N];

        ans = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0] = true;
        dfs(1, 0, 0 );

        System.out.println(ans);

    }

    static void dfs(int cnt, int cur, int dis) {
        if(dis > ans) return;
        if(cnt == N) {
            if(map[cur][0] != 0) {
                ans = Math.min(ans, dis + map[cur][0]);
            }


            return;
        }


        for(int i = 1; i < N; i++) {
            if(visited[i] || map[cur][i] == 0) continue;
            visited[i] = true;
            dfs(cnt + 1, i, dis + map[cur][i]);
            visited[i] = false;
        }
    }
}
