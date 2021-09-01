package 알고리즘이론.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_15650_N과M_2 {
    static int N;
    static int M;
    static int[] numbers;
    static int[] ans;

    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = i+1;
        }
        ans = new int[M];
        combi(0,0);
//        combi2(N,M, 0,0);
    }

    static void combi(int cnt, int start) {
        if(cnt == M) {
//            System.out.println(Arrays.toString(ans));
            for(int a : ans) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }
        for(int i = start; i < N; i++) {
            ans[cnt] = numbers[i];;
            combi(cnt+1, i + 1);
//            combi(cnt, i+1);
        }

    }
    static void combi3(int cnt, int start, int sum) {
        if (cnt == M) {
            System.out.println(Arrays.toString(ans));
            System.out.println(sum);
            return;
        }
        for (int i = start; i < N; i++) {
            ans[cnt] = numbers[i];



        }
    }




    static void combi2(int n, int r, int cnt, int start) {
        if(r == 0) {
            System.out.println(Arrays.toString(ans));
            return;
        }
        if(n < r) {
            return;
        }
        ans[cnt] = numbers[start];
        combi2(n, r-1, cnt + 1, start+1);
        combi2(n, r, cnt+1, start+1);
    }
}
