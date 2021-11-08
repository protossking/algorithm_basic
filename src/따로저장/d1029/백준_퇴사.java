package 따로저장.d1029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_퇴사 {
    static int N;
    static int[][] s;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        s = new int[N][2];


        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            s[i][0] = Integer.parseInt(st.nextToken());
            s[i][1] = Integer.parseInt(st.nextToken());

        }




    }
}
