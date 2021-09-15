package 알고리즘이론.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_15651_N과M3 {

    static int n;
    static int r;

    static int[] numbers;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        numbers = new int[r];
        permutation(0);
        System.out.println(sb.toString());

    }
    static void permutation(int cnt) {
        if(cnt == r) {
            for(int num : numbers) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            numbers[cnt] = i;
            permutation(cnt + 1);
        }
    }
}
