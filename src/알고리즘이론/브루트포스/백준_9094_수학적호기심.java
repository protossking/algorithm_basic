package 알고리즘이론.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_9094_수학적호기심 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());


        for(int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for(int b = 1; b < n; b++) {
                for(int a = 1; a < b; a ++) {
                    if((((a*a) + (b*b) + m)%(a*b)) == 0  ) {

                        cnt ++;
                    }
                }
            }
            System.out.println(cnt);
        }

    }
}
