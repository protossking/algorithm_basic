package 따로저장.d1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_S2_차이를최대로 {

    static int[] map;
    static int[] map2;
    static int N;
    static int ans;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        map = new int[N];
        for(int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());

        }
        map2 = new int[N];
        visited = new boolean[N];
        ans = 0;
        recur(0);
        System.out.println(ans);


    }


    static int sum(int[] arr) {
        int len = arr.length;
        int sum = 0;

        for(int i = 0; i < len-1; i++) {
            sum += Math.abs(arr[i] - arr[i+1]);
        }
        return sum;
    }

    static void recur(int depth) {
        if(depth == map.length) {


            ans = Math.max(sum(map2), ans);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i])continue;
            visited[i] = true;
            map2[depth] = map[i];
            recur(depth+1);
            visited[i] = false;
        }
    }


}
