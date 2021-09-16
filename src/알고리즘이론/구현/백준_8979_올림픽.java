package 알고리즘이론.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_8979_올림픽 {

    static int N;
    static int K;
    static int[][] map;
    static int rank;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][4];
        rank = 0;
        for(int i = 0; i < map.length; i++) {
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < 4; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; i++) {
            if(map[i][1] > map[findIndex(K)][1]) {
                rank++;
            }
            if(map[i][1] == map[findIndex(K)][1] && map[i][2] > map[findIndex(K)][2]) {
                rank ++;
            }
            if(map[i][1] == map[findIndex(K)][1] && map[i][2] == map[findIndex(K)][2] && map[i][3] > map[findIndex(K)][3]) {
                rank ++;
            }
        }
        System.out.println(rank +1 );
    }

    static int findIndex(int k) {
        for(int i = 0; i < map.length; i++) {
            if(map[i][0] == k) {
                return i;
            }
        }
        return 0;
    }
}
