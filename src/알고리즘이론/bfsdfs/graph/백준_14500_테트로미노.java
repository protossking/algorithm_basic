package 알고리즘이론.bfsdfs.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_14500_테트로미노 {

    static int N;
    static int M;

    static int[][] map;
    static int sum;

    static int[] dr = {-1, 1 , 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int max;
    static boolean[][] isVisited;


    static int[] fdr1 =  {0, 0, 1, -1};    // ㅓㅓㅓ
    static int[] fdc1 =  {0, -1, 0, 0};  //

    static int[] fdr2 = {0,  1, 0, 0}; // ㅗㅗㅗ
    static int[] fdc2 = {0, 0, -1, 1};

    static int[] fdr3 = {0, 1, -1, 0}; // ㅏㅏㅏ
    static int[] fdc3 = {0, 0, 0, 1};

    static int[] fdr4 = {0, 0, 0, -1}; // ㅜㅜs
    static int[] fdc4 = {0, -1, 1, 0};



    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];
        max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < M; j++) {
                dfs(i,j,0,0);
                f2(i,j);

            }
        }
        System.out.println(max);
    }
    public static void dfs(int r, int c, int sum, int cnt) {
        if(cnt == 4) {
            max = Math.max(sum, max);
            return;
        }

        for(int adj = 0; adj < 4; adj ++) {
            int nr = r + dr[adj];
            int nc = c + dc[adj];
            if(isIn(nr,nc) && !isVisited[nr][nc]) {
                isVisited[nr][nc] = true;
                dfs(nr, nc, sum + map[nr][nc] , cnt +1);
                isVisited[nr][nc] = false;
            }
        }
    }

    static void check(int r, int c) {
        int value = map[r][c];
        for(int i = 0; i < 4; i++) {

            for(int j = 0; j < 4; j++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(i == j) {
                    continue;
                }

                if(isIn(nr, nc)) {
                    value += map[nr][nc];
                }
            }
            if(max <= value) {
                max = value;
            }
            value = map[r][c];

        }


    }


    public static void f1(int r, int c) {
        /*
         static int[] fdr1 =  {0, -1, 0, 0};    // ㅓㅓㅓ
        static int[] fdc1 =  {0, 0, 1, -1};  //
        1,1
        0,1
        1,2
        1,0
         */
        int first = 0;
        for(int i = 0 ; i < 4; i ++) {
            int nr = r + fdr1[i];
            int nc = c + fdc1[i];

            if(isIn(nr, nc)) {
                first += map[nr][nc];
            }
            else{
                break;
            }

        }
        sum = Math.max(first, sum);
    }
    public static void f2(int r, int c) {
        /*
        static int[] fdr2 = {0,  0, -1, 1}; // ㅗㅗㅗ
        static int[] fdc2 = {0, 1, 0, 0};
        1 , 1
        1 , 2
        0 , 1
        2, 1

         */
        int second = 0;
        for(int i = 0 ; i < 4; i ++) {
            int nr = r + fdr2[i];
            int nc = c + fdc2[i];

            if(isIn(nr, nc)) {
                second += map[nr][nc];
            }
            else{
                break;
            }

        }
        sum = Math.max(sum, second);
    }
    public static void f3(int r, int c) {
        /*
        static int[] fdr3 = {0, 0, 0,1}; // ㅏㅏㅏ
        static int[] fdc3 = {0, 1, -1, 0};

        11
        12
        10
        21
         */
        int third = 0;
        for(int i = 0 ; i < 4; i ++) {
            int nr = r + fdr3[i];
            int nc = c + fdc3[i];

            if(isIn(nr, nc)) {
                third += map[nr][nc];
            }
            else{
                break;
            }

        }
        sum = Math.max(sum, third);
    }
    public static void f4(int r, int c) {

        /*
        static int[] fdr4 = {0, -1, 1, 0}; // ㅜㅜ
        static int[] fdc4 = {0, 0, 0, -1};
        11
        01
        21
        10
         */
        int fourth= 0;
        for(int i = 0 ; i < 4; i ++) {
            int nr = r + fdr4[i];
            int nc = c + fdc4[i];

            if(isIn(nr, nc)) {
                fourth += map[nr][nc];
            }
            else{
                break;
            }

        }
        sum = Math.max(fourth, sum);
    }


    static boolean isIn(int n, int r) {
        if(n > -1 && n < N && r > -1 && r < M) {
            return true;
        }
        return false;
    }
}
