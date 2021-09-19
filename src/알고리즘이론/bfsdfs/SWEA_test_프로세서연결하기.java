package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_test_프로세서연결하기 {

    static int[][] map;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(in.readLine());
            map = new int[N][N];
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            already(map);
            for(int i =0 ; i < N; i++) {
                System.out.println(Arrays.toString(map[i]));
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == 1) {
                        dfs(i, j);
                    }
                }
            }


        }
    }

    static void dfs(int r, int c) {
        visited[r][c] = true;


    }

    static void already(int[][] map) {
        for(int i = 0; i < N; i++) {
            if(map[i][0] == 1) {
                map[i][0] = 2;
            }
            if(map[0][i] == 1) {
                map[0][i] = 2;
            }
        }

    }
}
