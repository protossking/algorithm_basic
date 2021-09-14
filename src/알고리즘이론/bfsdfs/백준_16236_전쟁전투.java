package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.DoubleStream;

public class 백준_16236_전쟁전투 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;

    static int n;
    static int m;

    static char[][] map;


    static int w;
    static int b;
    static int cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] c = in.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = c[j];
            }
        }
        w = 0;
        b = 0;
        cnt = 0;
        int wa = 0;
        int ba = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(!visited[i][j]) {
                    cnt = 1;
                    dfs(i,j);
                    if(map[i][j] == 'W') {
                        wa += cnt * cnt;
                    } else {
                        ba += cnt * cnt;
                    }
                }
            }
        }
        System.out.println(wa +" "+ba);



    }

    static void dfs(int r, int c) {

        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr <0 || nc <0 || nr >= n || nc >= m) continue;
            if(visited[nr][nc]) continue;
            if(map[r][c] != map[nr][nc]) continue;

            dfs(nr,nc);
            cnt++;
        }


    }


}
