package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001_파리퇴치 {

    static int[][] map;
    static int[][] fly;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        for(int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            fly = new int[M][M];
            for(int i = 0; i < N; i ++) {
                st = new StringTokenizer(in.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < N-M+1; i++) {
                for(int j = 0; j < N-M +1 ; j++) {
                    int sum = 0;
                    for(int k = i; k < i+M; k++) {
                        for(int l = j; l < j+M; l++) {
                            sum += map[k][l];
                        }
                    }
                    max = Math.max(sum, max);
                }
            }
            System.out.println(max);


        }






    }
}
