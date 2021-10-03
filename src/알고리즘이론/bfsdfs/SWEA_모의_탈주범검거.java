package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_모의_탈주범검거 {

    static int N;
    static int M;
    static int R;
    static int C;
    static int L;

    static int[][] map;
    static boolean[][] visited;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int ans;

    static class Point {
        int r;
        int c;
        int dist;

        public Point(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc=1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            int cnt = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(R, C, L);
//            System.out.println(ans);
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(visited[i][j]){
                        cnt++;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
    static void bfs(int k, int l, int time) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(k, l, time-1));
        visited[k][l] = true;


        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int r = p.r;
            int c = p.c;

            int pipe = map[r][c];



            if(pipe == 1) {
                for(int adj = 0; adj < 4; adj++) {
                    int nr = r + dr[adj];
                    int nc = c + dc[adj];

                    if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
                        continue;
                    }
                    if((adj == 0) && (map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 7)) continue;
                    else if((adj == 1) && (map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 6)) continue;
                    else if((adj == 2) && (map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7)) continue;
                    else if((adj == 3) && (map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 5)) continue;


                    if(!visited[nr][nc] && p.dist > 0 && map[nr][nc] != 0) {
                        visited[nr][nc] = true;
                        queue.offer(new Point(nr,nc,p.dist -1));


                    }


                }

            }
            else if(pipe == 2) {
                for(int adj = 0; adj < 2; adj++) {
                    int nr = r + dr[adj];
                    int nc = c + dc[adj];

                    if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
                        continue;
                    }
                    if((adj == 0) && (map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 7)) continue;
                    else if((adj == 1) && (map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 6)) continue;
                    else if((adj == 2) && (map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7)) continue;
                    else if((adj == 3) && (map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 5)) continue;


                    if(!visited[nr][nc] && p.dist > 0 && map[nr][nc] != 0) {
                        visited[nr][nc] = true;
                        queue.offer(new Point(nr,nc,p.dist -1));


                    }

                }

            }
            else if(pipe == 3) {
                for(int adj = 2; adj < 4; adj ++) {
                    int nr = r + dr[adj];
                    int nc = c + dc[adj];

                    if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
                        continue;
                    }
                    if((adj == 0) && (map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 7)) continue;
                    else if((adj == 1) && (map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 6)) continue;
                    else if((adj == 2) && (map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7)) continue;
                    else if((adj == 3) && (map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 5)) continue;


                    if(!visited[nr][nc] && p.dist > 0 && map[nr][nc] != 0) {
                        visited[nr][nc] = true;
                        queue.offer(new Point(nr,nc,p.dist -1));


                    }
                }

            }
            else if(pipe == 4) {

                for(int adj = 0; adj < 4; adj +=3) {
                    int nr = r + dr[adj];
                    int nc = c + dc[adj];

                    if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
                        continue;
                    }
                    if((adj == 0) && (map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 7)) continue;
                    else if((adj == 1) && (map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 6)) continue;
                    else if((adj == 2) && (map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7)) continue;
                    else if((adj == 3) && (map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 5)) continue;


                    if(!visited[nr][nc] && p.dist > 0 && map[nr][nc] != 0) {
                        visited[nr][nc] = true;
                        queue.offer(new Point(nr,nc,p.dist -1));


                    }
                }


            }
            else if(pipe == 5) {

                for(int adj = 1; adj < 4; adj +=2) {
                    int nr = r + dr[adj];
                    int nc = c + dc[adj];

                    if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
                        continue;
                    }
                    if((adj == 0) && (map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 7)) continue;
                    else if((adj == 1) && (map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 6)) continue;
                    else if((adj == 2) && (map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7)) continue;
                    else if((adj == 3) && (map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 5)) continue;


                    if(!visited[nr][nc] && p.dist > 0 && map[nr][nc] != 0) {
                        visited[nr][nc] = true;
                        queue.offer(new Point(nr,nc,p.dist -1));


                    }
                }


            }
            else if(pipe == 6) {

                for(int adj = 1; adj < 3; adj ++) {
                    int nr = r + dr[adj];
                    int nc = c + dc[adj];

                    if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
                        continue;
                    }
                    if((adj == 0) && (map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 7)) continue;
                    else if((adj == 1) && (map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 6)) continue;
                    else if((adj == 2) && (map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7)) continue;
                    else if((adj == 3) && (map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 5)) continue;


                    if(!visited[nr][nc] && p.dist > 0 && map[nr][nc] != 0) {
                        visited[nr][nc] = true;
                        queue.offer(new Point(nr,nc,p.dist -1));


                    }
                }

            }
            else if(pipe == 7) {

                for(int adj = 0; adj < 3; adj +=2) {
                    int nr = r + dr[adj];
                    int nc = c + dc[adj];

                    if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
                        continue;
                    }
                    if((adj == 0) && (map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 7)) continue;
                    else if((adj == 1) && (map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 6)) continue;
                    else if((adj == 2) && (map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7)) continue;
                    else if((adj == 3) && (map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 5)) continue;


                    if(!visited[nr][nc] && p.dist > 0 && map[nr][nc] != 0) {
                        visited[nr][nc] = true;
                        queue.offer(new Point(nr,nc,p.dist -1));


                    }
                }

            }

        }
    }
}
