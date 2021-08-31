package 알고리즘이론.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1018_체스판다시칠하기 {

    static boolean[][] map;
    static boolean temp;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            String s = in.readLine();
            for(int j = 0; j < M; j++) {
                if(s.charAt(j) == 'W') {
                    map[i][j] = true;
                }else{
                    map[i][j] = false;
                }
            }
        }
        for(int i = 0; i <N-7; i++) {

            for(int j = 0; j < M-7; j++) {
                cnt = 0;
                temp = map[i][j];
                for(int k = i; k < i+8; k++) {

                    for(int l = j; l < j+8; l++) {


                        if(temp != map[k][l]) {
                            cnt ++;
                        }
                        temp = !temp;
                    }
                    temp = !temp;
                }
                cnt = Math.min(cnt, 64-cnt);
                min = Math.min(min, cnt);

            }
        }
        System.out.println(min);


    }


}
