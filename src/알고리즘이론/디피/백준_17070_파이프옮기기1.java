package 알고리즘이론.디피;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_17070_파이프옮기기1 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[][] map = new int[N+1][N+1];
        int[][][] dp = new int[N+1][N+1][3];

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 2; i < N+1; i++) {
            for(int j = 2; j < N+1; j++) {

            }
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 2; j <=N; j++) {
                if(map[i][j] != 1) {
                    dp[i][j][0] = dp[i][j-1][0] + dp[i-1][j-1][1];

                }
            }
        }





    }
}
