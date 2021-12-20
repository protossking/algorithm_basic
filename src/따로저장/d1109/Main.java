package 따로저장.d1109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static boolean[] visited;
    static int[] ans;

    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        visited = new boolean[N];
        ans = new int[N];

        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken()) -1;
            int b = Integer.parseInt(st.nextToken()) -1;
            list[a].add(b);

        }

        for(int i = 0; i < N; i++) {
            visited = new boolean[N];
            bfs(i);
//            dfs(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < ans.length; i++) {
            if(ans[i] > max) {
                max = ans[i];
            }
        }
        for(int i = 0; i < ans.length; i++) {
            if(ans[i] == max) {
//                System.out.print(i+1)+" ");
                sb.append(i+1).append(" ");
            }
        }
        System.out.println(sb.toString());

    }
    static void dfs(int cur) {
        visited[cur] = true;

//        for(int adj = 0; adj < list[cur].size(); adj++) {
//            if(!visited[adj]) {
//                ans[adj] ++;
//                dfs(adj);
//            }
//        }
    }

    static void bfs(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(cur);
        visited[cur] = true;



//        while(!queue.isEmpty()) {
//            int poll = queue.poll();
//            for(int i: list[poll]) {
//                if(visited[i]) continue;
//                ans[i] ++;
//                visited[i] = true;
//                queue.offer(i);
//
//            }
//        }
        // 왜 안돼ㅐ
       while(!queue.isEmpty()) {
            int poll = queue.poll();

            for(int adj =0 ; adj < list[poll].size(); adj++) {
                if(visited[adj]) continue;
                ans[adj] ++;
                visited[adj] = true;
                queue.offer(adj);

            }
        }
    }
}
