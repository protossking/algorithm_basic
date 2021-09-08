package 알고리즘이론.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1051_숫자정사각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for(int i = 0; i < N; i++) {
            char[] c = in.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                map[i][j] = c[j] - '0';
            }
        }
        int res = Integer.MIN_VALUE;
        int k = 0 ;
        int min = Math.min(N, M);
        int count = 0;
        top:
        while(min>0) {



            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {

                        if(i+min-1 < N && j + min-1 < M) {
                            if(map[i][j] == map[i+min-1][j]) {
                                if(map[i][j] == map[i+min-1][j+min-1]) {
                                    if(map[i][j] == map[i][j+min-1]) {

                                        System.out.println(min * min);
                                        break top;

                                    }
                                }
                            }
                        } else {
                            break ;
                        }

                }
            }
            min--;






        }




    }
}
