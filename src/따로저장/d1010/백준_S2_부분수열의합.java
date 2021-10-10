package 따로저장.d1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_S2_부분수열의합 {

    static int N;
    static int S;
    static int count;

    static int[] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        map = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        count = 0;
        subset(0, 0);


        if( S == 0) {
            count --;
        }

        System.out.println(count);

    }
    static void subset(int depth, int sum) {
        if(depth == map.length) {
            if( S == sum) {
                count ++;
            }
            return;

        }

        subset(depth + 1, sum + map[depth]);
        subset(depth + 1, sum);


    }
}


/*

    배열길이랑  뎁스가 같을떄

    선택한거랑 s 가 같을떄 {


 */