package 알고리즘이론.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_17143_낚시왕 {

    static int R;
    static int C;
    static int M;

    static Shark[][] map;
    static int ans;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Shark {
        int r;
        int c;
        int s;
        int d;
        int z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Shark{");
            sb.append("r=").append(r);
            sb.append(", c=").append(c);
            sb.append(", s=").append(s);
            sb.append(", d=").append(d);
            sb.append(", z=").append(z);
            sb.append('}');
            return sb.toString();
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R][C];
        ans = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()); // 1 위 2 아래 3 우 4 좌
            int z = Integer.parseInt(st.nextToken());

            map[r][c] = new Shark(r, c, s, d, z);
        }


        for (int i = 0; i < C; i++) {

            t:
            for (int j = 0; j < R; j++) {
                if (map[j][i] != null) {
                    ans += map[j][i].z;
                    map[j][i] = null;
                    break t;
                }
            }


            // 1 위 2 아래 3 우 4 좌
            ArrayList<Shark> list = new ArrayList();
            ArrayList<Shark> list2 = new ArrayList<>();
            for (int k = 0; k < R; k++) {
                for (int l = 0; l < C; l++) {
                    if (map[k][l] != null) {
                        list.add(map[k][l]);
                    }
                }
            }

//            map = new Shark[R][C];
            // 1 위 2 아래 3 우 4 좌
            for (int k = 0; k < list.size(); k++) {
                Shark shark = list.get(k);
                int dir = shark.d;
                int speed = shark.s;
                int r = shark.r;
                int c = shark.c;
                int w = shark.z;

                int nr = r;
                int nc = c;

                for (int l = 0; l < shark.s; l++) {
                    if (dir == 1) {

                        nr += dr[0];
                        nc += dc[0];
                        if (nr == 0) {
                            dir = 2;
                            continue;
                        }
                    }
                    if (dir == 2) {

                        nr += dr[1];
                        nc += dc[1];
                        if (nr == R - 1) {
                            dir = 1;
                            continue;
                        }
                    }
                    if (dir == 3) { // 우

                        nr += dr[3];
                        nc += dc[3];
                        if (nc == C - 1) {
                            dir = 4;
                            continue;
                        }
                    }
                    if (dir == 4) {

                        nr += dr[2];
                        nc += dc[2];
                        if (nc == 0) {
                            dir = 3;
                            continue;
                        }
                    }
                }
                list2.add(new Shark(nr,nc,speed,dir,w));

//                if(map[nr][nc] == null) {
//                    map[nr][nc] = new Shark(nr, nc, speed, dir, w);
//                } else {
//                    if(map[r][c].z < w) {
//                        map[nr][nc] = new Shark(nr, nc, speed, dir, w);
//                    }
//                }



            }

            for(int j = 0; j < list.size(); j++) {
                System.out.println(list.get(j));
            }
            System.out.println("---------");
            for(int j = 0; j < list2.size(); j++) {
                System.out.println(list2.get(j));
            }

            for(int a = 0; a < list.size(); a++) {
                for(int b = 0; b < list2.size(); b++) {
                    if((list.get(a).r == list2.get(b).r) && (list2.get(a).c == list2.get(b).c)) {
                        if(list.get(a).z < list2.get(b).z) {
                            map[list2.get(a).r][list2.get(b).c] = list2.get(b);
                        }
                    } else {

                    }
                }
            }


        }

        System.out.println(ans);
    }
}
