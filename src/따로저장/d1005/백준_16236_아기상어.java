package 따로저장.d1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 백준_16236_아기상어 {

    static class Shark implements Comparator<Shark> {
        int r;
        int c;
        int size;
        int dist;

        public Shark(int r, int c, int size, int dist) {
            this.r = r;
            this.c = c;
            this.size = size;
            this.dist = dist;
        }

        @Override
        public int compare(Shark o1, Shark o2) {
            if (o1.r < o2.r) {
                return -1;
            } else if (o1.r == o2.r) {
                if (o1.c < o2.c) {
                    return -1;
                } else if (o1.c == o2.c) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int eat;
    static int ans;
    static boolean check;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        int r = 0;
        int c = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 9) {
                    r = i;
                    c = j;
                    map[i][j] = 0;
                }
            }
        }


        eat = 0;
        ans = 0;
        while (true) {

            visited = new boolean[N][N];
            PriorityQueue<Shark> queue = new PriorityQueue<>();
            queue.add(new Shark(r, c, 2, 0));
            visited[r][c] = true;

            check = false;

            while (!queue.isEmpty()) {

                Shark s = queue.poll();
                int sr = s.r;
                int sc = s.c;
                int size = s.size;
                int dist = s.dist;

                if (map[sr][sc] != 0 && map[sr][sc] < size) {
                    map[sr][sc] = 0;
                    eat++;
                    ans += dist;
                    check = true;
                    break;
                }

                for (int adj = 0; adj < 4; adj++) {
                    int nr = sr + dr[adj];
                    int nc = sc + dc[adj];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                    queue.add(new Shark(nr, nc, size, dist + 1));
                    visited[nr][nc] = true;
                }

                if(size == eat) {
                    size ++;
                    eat = 0;
                }

            }
            if (!check) {
                break;
            }



        }
        System.out.println(ans);
    }


}
