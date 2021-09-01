package 알고리즘이론.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_15654_N과M_5 {
    static int N;
    static int M;
    static int[] nums;
    static int[] ans;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //N 과 M 둘째줄에 N 배열 이 나와있고 M 이 뽑는수
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        ans = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        permutation(0);
    }

    static void permutation(int cnt) {
        if(cnt == M) {
            for(int a : ans) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < N; i++) {
            if (visited[i]) continue;
            ans[cnt] = nums[i];
            visited[i] = true;
            permutation(cnt + 1);
            visited[i] = false;
        }
    }
}
