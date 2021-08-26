package 스터디.d0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2567_색종이2 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int pNum = Integer.parseInt(in.readLine());
        int[][] map = new int[101][101];
        for(int tc = 0 ; tc < pNum; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int i = x; i < x + 10; i++) {
                for(int j = y; j < y+10; j++) {
                    map[i][j] = 1;
                }
            }
        }

        for(int r = 0; r < map.length; r++) {
            for(int c = 0; c < map.length; c++) {
                if(map[r][c] == 1) {
                    for(int adj = 0; adj < 4; adj ++) {
                        int nr = r + dr[adj];
                        int nc = c + dc[adj];
                        if(map[nr][nc] == 0) {
                            ans++;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
