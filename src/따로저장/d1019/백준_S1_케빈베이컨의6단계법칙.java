package 따로저장.d1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_S1_케빈베이컨의6단계법칙 {


    static int[][] map;
    static boolean[] visited;
    static int M;
    static int N;
    static int[] ans;
    static int sum;
    static int min;


    static int[] man;



    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[5000][101];
        visited = new boolean[N];
        ans = new int[N];
        min = Integer.MAX_VALUE;
        sum = 0;
        man = new int[N];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            map[a][b] = 1;
            map[b][a] = 1;
        }

        for(int i = 0 ; i < N; i++) {
            bfs(i);
//            visited = new boolean[M];
            Arrays.fill(visited, false);
            Arrays.fill(ans, 0);

        }


        int a = Integer.MAX_VALUE;

        for(int i = 0; i < man.length; i++) {

            a = Math.min(a, man[i]);
        }
//        System.out.println(a);

        for(int i = 0; i < man.length; i++) {
            if(a == man[i]) {
                System.out.println(i+1);
                break;
            }
        }

    }

    static void bfs(int cur2) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(cur2);
        visited[cur2] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i = 0; i < N; i++) {
                if(visited[i]) continue;
                if(map[cur][i] == 0) continue;
                ans[i] = ans[cur] + 1;
                queue.offer(i);
                visited[i] = true;

            }
        }
        sum = 0;
        for(int i = 0; i < ans.length; i++) {
            sum += ans[i];
        }
        man[cur2] = sum;


    }
}


