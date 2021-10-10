package 따로저장.d1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_G5_적록색약 {

    static char[][] map;
    static boolean[][] visited;
    static int N;
    static int[]dr = {-1, 1, 0, 0};
    static int[]dc = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String s = in.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }


        int cnt = 0;
        int ncnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j< N; j++) {
                if(map[i][j] == 'R' && !visited[i][j]) {
                    dfs(i,j);
                    cnt++;
                }
                if(map[i][j] == 'G' && !visited[i][j]) {
                    dfs(i,j);
                    cnt++;
                }
                if(map[i][j] == 'B' && !visited[i][j]) {
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j< N; j++) {
                if((map[i][j] == 'R' || map[i][j] =='G') && (!visited[i][j])) {
                    dfs2(i,j);
                    ncnt++;
                }

                if(map[i][j] == 'B' && !visited[i][j]) {
                    dfs2(i,j);
                    ncnt++;
                }
            }
        }
        System.out.println(cnt + " " + ncnt);

    }

    static void dfs(int i, int j) {

        visited[i][j] = true;

        for(int adj = 0; adj < 4; adj ++) {
            int nr = i + dr[adj];
            int nc = j + dc[adj];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if(visited[nr][nc]) continue;
            if(map[nr][nc] != map[i][j]) continue;
            dfs(nr, nc);
        }
    }
    static void dfs2(int i, int j) {

        visited[i][j] = true;

        for(int adj = 0; adj < 4; adj ++) {
            int nr = i + dr[adj];
            int nc = j + dc[adj];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if(visited[nr][nc]) continue;
//            if(map[nr][nc] != map[i][j]) continue;
            if(map[i][j] == 'R' || map[i][j] =='G') {
                if(map[nr][nc] == 'R' || map[nr][nc] == 'G') {
                    dfs2(nr, nc);
                }
            }
            if(map[i][j] == 'B') {
                if(map[nr][nc] == 'B') {
                    dfs2(nr,nc);
                }
            }

        }
    }
}


/*
 dfs 탐색을 할때
 for
    for
        if(map[r][c] 가 r || c ) 일떄 탐색하고 의 ans 값
        if(mao pp 탐색하고 )  값
        dfs 가 두개 ?


 */