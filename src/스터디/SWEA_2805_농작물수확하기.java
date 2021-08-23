package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.Buffer;
import java.util.Arrays;

public class SWEA_2805_농작물수확하기 {
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(src));
        in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());


        for(int tc = 1; tc <= T; tc ++) {
            int N = Integer.parseInt(in.readLine());
            map = new int[N][N];

            for(int i = 0; i < N; i++) {
                String s = in.readLine();
                for(int j = 0; j< N; j++) {
                    map[i][j] = (int)(s.charAt(j)-'0');
                }
            }
            int sum1 = 0;
            for(int i = 0; i < N/2; i++) {
                for(int j = N/2-i; j <= N/2+i; j ++ ) {
                    sum1 += map[i][j];
                }
            }
            for(int i = N/2; i >= 0; i--) {

                for(int j = N/2-i; j <=N/2+i; j++) {
                    sum1 += map[N-i-1][j];
                }


            }
            System.out.printf("#%d %d\n", tc, sum1);
        }
    }

    static String src = "1\n" +
            "5\n" +
            "14054\n" +
            "44250\n" +
            "02032\n" +
            "51204\n" +
            "52212";
}
