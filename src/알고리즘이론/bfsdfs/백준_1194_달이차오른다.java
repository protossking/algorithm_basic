package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1194_달이차오른다 {

    static char[][] map;
    static int n;
    static int m;
    static boolean visited[][][];
    static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    static class Point {
        int r;
        int c;
        int dis;
        int key;

        public Point(int r, int c, int dis, int key) {
            this.r = r;
            this.c = c;
            this.dis = dis;
            this.key = key;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m][64];

        for(int i = 0; i < n; i++) {
            String s = in.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == '0') {
                    bfs(i, j);
                }
            }
        }





    }

    static void bfs(int i , int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j, 0, 0));
        visited[i][j][0] = true;


        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int r = p.r;
            int c = p.c;
            int dis = p.dis;
            int key = p.key;

            if(map[r][c] == '1') {
                System.out.println(dis);
                return;
            }

            for(int adj = 0; adj < 4; adj ++) {
                int nr = r + delta[adj][0];
                int nc = c + delta[adj][1];

                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if(map[nr][nc] == '#') continue;
                if(visited[nr][nc][key]) continue;

//                if(map[nr][nc] == '.' || map[nr][nc] == '1') {
//                    visited[nr][nc][key] = true;
//                    queue.add(new Point(nr, nc, dis+1, key));
//                }
                if (map[nr][nc] - 'a' >= 0 && map[nr][nc] -'a' < 6) {

                    int tmp = (1 << (map[nr][nc] - 'a')) | key;
                    if(!visited[nr][nc][tmp]) {
                        visited[nr][nc][key] = true;
                        visited[nr][nc][tmp] = true;
                        queue.add(new Point(nr, nc, dis +1, tmp));
                    }
                }
                else if (map[nr][nc] - 'A' >= 0 && map[nr][nc] - 'A' < 6) {
                    int tmp2 = (1 << (map[nr][nc] - 'A')) & key;

                    if(tmp2 > 0) {
                        visited[nr][nc][tmp2] = true;
                        queue.add(new Point(nr, nc, dis +1, key));

                    }
                }
                else {
                    visited[nr][nc][key] = true;
                    queue.add(new Point(nr, nc, dis+1, key));
                }
            }

        }
//        System.out.println(-1);
    }

}
