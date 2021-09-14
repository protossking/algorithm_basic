package 알고리즘이론.디피;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정올_1411_두줄로타일깔기 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        long[] tile = new long[N+1];
        tile[1] = 1;
        tile[2] = 3;
        for(int i = 3; i < N+1; i++) {
               tile[i] = (tile[i-1] + tile[i-2]*2)% 20100529;
        }
        System.out.println(tile[N]);

    }
}
