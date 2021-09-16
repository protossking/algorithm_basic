package 알고리즘이론.디피;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D6_사람네트워크 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
        int T = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc = 1 ; tc <=T; tc++) {
            int max = Integer.MAX_VALUE>>2;

            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] map =new int[N][N];

            for(int i = 0; i < N; i++) {

                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if(i != j && map[i][j] == 0) {
                        map[i][j] = max;
                    }
                }
            }

            for(int k = 0; k < map.length; k++) {

                for(int i = 0; i < N; i++) {
                    if( i == k) continue;
                    for(int j = 0; j < N; j++) {
                        if(i == j || k == j) continue;
                        if(map[i][j] > map[i][k] + map[k][j]) {
                            map[i][j] = map[i][k] + map[k][j];
                        }
                    }
                }
            }

//            for(int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
            for (int i = 0; i < N; i++) {
                int t = 0;
                for (int j = 0; j < N; j++) t += map[i][j];
                max = Math.min(max , t);
            }

            sb.append("#").append(tc).append(" ").append(max).append("\n");



        }
        System.out.println(sb.toString());
    }
}
