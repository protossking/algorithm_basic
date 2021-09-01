package 알고리즘이론.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_15649_N과M {

    static int[] nums;
    static boolean[] visited;
    static int[] ans;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = i+1;
        }
        visited = new boolean[N];
        ans = new int[M];


        //n 중에 M개 를 뽑는다.
        permutation(0);

    }
    static void permutation(int cnt) {
        if(cnt == M) {
            for(int a :  ans) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            ans[cnt] = nums[i];
            visited[i] = true;
            permutation(cnt + 1);
            visited[i] = false;
        }
    }
}
