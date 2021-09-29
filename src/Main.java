import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int cnt;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

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
      ArrayList<Integer> list = new ArrayList<>();

      for(int i = 0; i < N; i++) {
          for(int j = 0; j < N; j++) {
              if(!visited[i][j] && map[i][j] == 1) {
                  cnt = 0;
                  dfs(i, j);
                  list.add(cnt);
              }
          }
      }
        System.out.println(list);

    }

    static void dfs(int r, int c) {
        visited[r][c] = true;
        cnt ++;
        for(int adj = 0; adj < 4; adj ++) {
            int nr = r + dr[adj];
            int nc = c + dc[adj];

            if(nr < 0 || nc < 0  || nr >= N || nc>= N) continue;
            if(visited[nr][nc]) continue;
            if(map[nr][nc] == 0) continue;

            dfs(nr, nc);

        }

    }


}







