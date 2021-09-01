import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int V;
    static int[][] map;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken()) -1;
            map[r][c] = 1;
            map[c][r] = 1;
        }

        dfs(V-1);
        System.out.println();
        visited = new boolean[N];
        bfs(V-1);



    }

    static void dfs(int cur) {
        visited[cur] = true;
        System.out.println(cur + 1 + " ");
        for(int adj = 0; adj < N; adj++) {
            if(map[cur][adj] != 0 && !visited[adj]) {
                dfs(adj);
            }
        }

    }

    static void bfs(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(cur);
        visited[cur] = true;

        while(!queue.isEmpty()) {

            cur = queue.poll();
            System.out.println(cur + 1 + " ");

            for(int adj = 0; adj < N; adj++) {
                if(map[cur][adj] != 0 && !visited[adj]) {
                    queue.offer(adj);
                    visited[adj] = true;
                }
            }

        }
    }


}




