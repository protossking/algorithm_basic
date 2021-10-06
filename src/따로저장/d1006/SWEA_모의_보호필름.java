package 따로저장.d1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_모의_보호필름 {

    static int[][] map;
    static int[][] map2;
    static int D;
    static int W;
    static int K;
    static int ans;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[D][W];
            map2 = new int[D][W];
            ans = Integer.MAX_VALUE;


            for(int i = 0; i < D; i++) {
                st = new StringTokenizer(in.readLine());
                for(int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    map2[i][j] = map[i][j];
                }
            }

            if(pass()) {
                ans = 0;
            }
            else {
                dfs(0,0);
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");

        }
        System.out.println(sb.toString());

    }

    static boolean pass() {
        // 열탐색 을 해서 연속으로 k 개 이상이 나오면 통과




        for(int i = 0; i < W; i++) {
            int cnt = 1;
            int type = map2[0][i];
            boolean flag = false;
            for(int j = 1; j < D; j++) {
              if(type == map2[j][i]) {
                  cnt ++;
              } else {
                  type = map2[j][i];
                  cnt = 1;
              }
              if(cnt == K) {
                  flag = true;
                  break;
              }

            }

            if(!flag) return false;
        }
        return true;





    }
    static void dfs(int cnt, int d) {

        if(cnt >= ans) {
            return;
        }
        if(d == D) {
            if(pass()) {
//                ans = Math.min(ans, cnt);
                ans = ans > cnt ? cnt : ans;
            }
            return;
        }

        dfs(cnt, d+1);
        //a
        for(int i = 0; i < W; i++) {
            map2[d][i] = 0;
        }
            dfs(cnt + 1, d + 1);

        for(int i = 0; i < W; i++) {
            map2[d][i] = 1;
        }
            dfs(cnt + 1, d + 1);


        for(int i = 0; i < W; i++) {
            map2[d][i] = map[d][i];
        }

    }
}
