import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int E = Integer.parseInt(in.readLine());

        int[][] map = new int[N][N];
        boolean[] visited = new boolean[N];
        for(int i = 0 ; i < E; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n1 = Integer.parseInt(st.nextToken())-1;
            int n2 = Integer.parseInt(st.nextToken())-1;
            map[n1][n2] = 1;
            map[n2][n1] = 1;
        }
        int cnt = 0;


        Queue<Integer> queue = new LinkedList<>();
        queue.offer(map[0][0]);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for(int adj = 0 ; adj < N; adj ++) {
                if(!visited[adj] && map[cur][adj] == 1) {
                    queue.offer(adj);
                    visited[adj] = true;
                    cnt ++;
                }
            }
        }
        System.out.println(cnt);



    }


}







