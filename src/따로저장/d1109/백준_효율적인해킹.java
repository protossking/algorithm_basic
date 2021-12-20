package 따로저장.d1109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_효율적인해킹 {

    static int N;
    static int M;

    static List<Integer>[] list;

    static boolean[] visited;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        ans = new int[N];

        list = new ArrayList[N];

        for(int i = 0 ; i < N; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken()) -1;
            int b = Integer.parseInt(st.nextToken()) -1;
            list[a].add(b);

        }
//        for(int i = 0; i < N; i++) {
//            visited = new boolean[N];
////            bfs(i);
//            dfs(i);
//        }

        for(int i = 0; i < N; i++) {
            visited = new boolean[N];
//            visited[i] = true;
//            dfs(i);
            bfs(i);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, ans[i]);
        }
        for(int i = 0; i < N; i++) {
            if(max == ans[i]) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb.toString());


    }
    static void bfs(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(cur);
        visited[cur] = true;
        while(!queue.isEmpty())  {
            cur = queue.poll();

            for(int i = 0; i < list[cur].size(); i++) {
                int num = list[cur].get(i);
                if(!visited[num]) {
                    ans[num]++;
                    visited[num] = true;
                    queue.add(num);
                }
            }

//            for(int next: list[cur]) {
//                if(!visited[next]) {
//                    ans[next] ++;
//                    visited[next] = true;
//                    queue.add(next);
//
//                }
//            }
        }
    }

    static void dfs(int cur) {

        for(int next: list[cur]) {
            if(!visited[cur]) {
                ans[next]++;
                visited[next] = true;
                dfs(next);
            }
        }
    }
}
