package 알고리즘이론.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;
/*
    dfs 탐색 달별로 할래 안할래 계속 반복 하면서 sum을 더해감

 */

public class SWEA_1952_수영장 {

    static int[] money;
    static int[] month;
    static int min;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(src));
        int T = Integer.parseInt(in.readLine());
        money = new int[4];
        month = new int[12];
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc<= T; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int i = 0 ; i < 4; i++) {
                money[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(in.readLine());
            for(int i = 0; i < 12; i++) {
                month[i] = Integer.parseInt(st.nextToken());
            }
            min = Integer.MAX_VALUE;

            dfs(0,0);
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.println(sb.toString());



    }
    static void dfs(int cnt, int sum) {
        if(cnt >= 12) {

            min = Math.min(sum, min);
            return;
        }
        if(month[cnt] == 0) {
            dfs(cnt+1, sum);
        }
        dfs(cnt + 1, sum + (month[cnt] * money[0]));
        dfs(cnt + 1, sum + money[1]);
        dfs(cnt +3, sum + money[2]);
        dfs(cnt + 12,  sum + money[3]);

    }


    static String src ="10\n" +
            "10 40 100 300\n" +
            "0 0 2 9 1 5 0 0 0 0 0 0\n" +
            "10 100 50 300\n" +
            "0 0 0 0 0 0 0 0 6 2 7 8\n" +
            "10 70 180 400\n" +
            "6 9 7 7 7 5 5 0 0 0 0 0\n" +
            "10 70 200 550\n" +
            "0 0 0 0 8 9 6 9 6 9 8 6\n" +
            "10 80 200 550\n" +
            "0 8 9 15 1 13 2 4 9 0 0 0\n" +
            "10 130 360 1200\n" +
            "0 0 0 15 14 11 15 13 12 15 10 15\n" +
            "10 180 520 1900\n" +
            "0 18 16 16 19 19 18 18 15 16 17 16\n" +
            "10 100 200 1060\n" +
            "12 9 11 13 11 8 6 12 8 7 15 6\n" +
            "10 170 500 1980\n" +
            "19 18 18 17 15 19 19 16 19 15 17 18\n" +
            "10 200 580 2320\n" +
            "12 28 24 24 29 25 23 26 26 28 27 22";
}
