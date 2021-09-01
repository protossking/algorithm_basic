package 알고리즘이론.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_15655_N과M_6 {
    static int N;
    static int M;
    static int[] numbers;
    static int[] ans;

    static boolean[] visited;
    static boolean tag;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        ans = new int[M];
        Arrays.sort(numbers);
        combi(0,0);

    }

    static void combi(int cnt, int start) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) {
                System.out.println(Arrays.toString(ans));
            }


            System.out.println();

            return;
        }
        for(int i = start; i < N; i++) {
            visited[i] = true;
            ans[cnt] = numbers[i];

            combi(cnt+1, i + 1);
            visited[i] = false;

        }
    }






}
