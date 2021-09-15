package 알고리즘이론.디피;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정올_1077_배낭채우기 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken()); // 보석 종류
        int W = Integer.parseInt(st.nextToken());

        int[] weight = new int[N+1];
        int[] profits = new int[N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(in.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            profits[i] = Integer.parseInt(st.nextToken());
        }
        int[][] back = new int[N+1][W+1];
        int[] dp = new int[W+1];


        for(int i = 1; i <= W; i++) {
            int max = 0;
            for(int j = 1; j <= N; j++) {
                if(back[j][0] <= i) {
                    back[j][i] = Math.max(back[j][i-1],   dp[i-back[j][0] + back[j][1]]);
                }else {
                    back[j][i] = back[j][i-1];
                }
                max = Math.max(max, back[j][i]);
            }
            dp[i] = max;
        }

        System.out.println(dp[W]);
    }
}

/*

 */