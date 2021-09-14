package 알고리즘이론.디피;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1010_다리놓기 {

    static int n;
    static int r;
    static int[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();


        for(int i =0 ; i < T; i++) {

            StringTokenizer st = new StringTokenizer(in.readLine());
            r = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            map = new int[31][31];


            sb.append(combi(n,r)).append("\n");

        }
        System.out.println(sb.toString());
    }

    static int combi (int n , int r) {
        if(r == 0 || n == r) {
            return 1;
        }
        if(map[n][r] > 0) {
            return map[n][r];
        }

         map[n][r]  = combi(n-1, r) + combi(n-1, r-1);
        return map[n][r];

    }
}
