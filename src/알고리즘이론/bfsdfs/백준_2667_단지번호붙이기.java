package 알고리즘이론.bfsdfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_2667_단지번호붙이기 {

    static int[][] map;
    static int[][] delta = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};

    static boolean[][] visited;
    static int cnt;
    static int N;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String s = in.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }


        list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }


//        System.out.println(list);
        Collections.sort(list);
        System.out.println(list.size());
        for(int c : list) {
            System.out.println(c);
        }

    }


    static void dfs(int r, int c) {

        cnt++;
        visited[r][c] = true;

        for(int adj = 0; adj < 4; adj ++) {
            int nr = r + delta[adj][0];
            int nc = c + delta[adj][1];

            if (nr < 0 ||  nc < 0 || nr >= N || nc >= N) continue;
            if(map[nr][nc] == 0) continue;
            if (visited[nr][nc]) continue;
            dfs(nr,  nc);

//            if(nr > -1 && nc > -1 && nr < N && nc < N && !visited[nr][nc]) {
//                if(map[nr][nc] == 1) {
//                    dfs(nr,nc);
//                }
//            }



        }

    }


}
