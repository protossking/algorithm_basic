package 따로저장.d1027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_G3_주사위굴리기2 {

    static int[][] map;
    static int N;
    static int M;
    static int K;

    static boolean[][] visited;

    static int[] d = {1,2,3,4,5,6};
    static int[] nd = {1,2,3,4,5,6};

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int adj;
    static int r;
    static int c;

    static boolean[][] dice;
    static List<Integer> list;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        dice = new boolean[N][M];

        list = new ArrayList<>();

        r = 0;
        c = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        adj = 0;
        while(K-- > 0) {

            move(); // 이동하고
            moveD();
            dfs(r, c);
            visited = new boolean[N][M];
//            list.add((count+1) * map[r][c]);
            check(r, c);

        }
        int sum  = 0;
        for(int i : list) {
            sum += i;
        }
        System.out.println(sum);




    }

    //좌표 이동 adj
    static void move() {
        if(adj == 0) { // 동
           c ++ ;
           if(!isRange(r,c)) {
               c = c-2;
               adj = 2;
           }

        }
        else if(adj == 1) { // 남
            r++;
            if(!isRange(r,c)) {
                r = r -2;
                adj = 3;
            }

        }
        else if(adj == 2) { // 서
            c--;
            if(!isRange(r,c)) {
                c = c + 2;
                adj = 0;
            }
        }
        else if(adj == 3) { // 북
            r--;
            if(!isRange(r,c)) {
                r = r + 2;
                adj = 1;
            }
        }
    }
    static boolean isRange(int i , int j) {
        if(i < 0 || j < 0 || i >= N || j >= M) {
            return false;
        }
        return true;
    }


    // 값 비교
    static void check(int i , int j) {
        if(d[5] > map[i][j]) {
            adj ++;
            adj = adj % 4;
        }
        else if (d[5] < map[i][j]) {
            adj --;
            if(adj < 0) {
                adj = adj +4;
            }
            adj = adj % 4;
        } else {
            adj = adj % 4;
        }
    }


    static void moveD() {
        if(adj == 0) { // 동
            d[0] = nd[3];
            d[1] = nd[1];
            d[2] = nd[0];
            d[3] = nd[5];
            d[4] = nd[4];
            d[5] = nd[2];
        }
        if(adj == 1) { // 남
            d[0] = nd[1];
            d[1] = nd[5];
            d[2] = nd[2];
            d[3] = nd[3];
            d[4] = nd[0];
            d[5] = nd[4];
        }

        if(adj == 2) { // 서
            d[0] = nd[2];
            d[1] = nd[1];
            d[2] = nd[5];
            d[3] = nd[0];
            d[4] = nd[4];
            d[5] = nd[3];
        }
        if(adj == 3) { // 북
            d[0] = nd[4];
            d[1] = nd[0];
            d[2] = nd[2];
            d[3] = nd[3];
            d[4] = nd[5];
            d[5] = nd[1];
        }
        for(int a=0; a<6; a++)
        {
            nd[a] = d[a];
        }
    }

    static void dfs(int i, int j) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        count = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for(int a = 0 ; a < 4; a ++) {
                int nr = r + dr[a];
                int nc = c + dc[a];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(visited[nr][nc]) continue;
                if(map[i][j] == map[nr][nc]) {
                    queue.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    count ++;
                }
            }
        }

    }

    static void d(int i , int j) {
        visited[i][j] = true;

        for(int adj = 0; adj < 4; adj ++) {
            int nr = i + dr[adj];
            int nc = j + dc[adj];


        }
    }

}
