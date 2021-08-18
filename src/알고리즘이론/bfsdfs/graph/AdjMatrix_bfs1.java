package 알고리즘이론.bfsdfs.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjMatrix_bfs1 {
    private static int[][] map; // 인접행렬 정보
    private static boolean[] visited;
    private static int n ;// 노드의 수

    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream("res/lecture/AdjMatrix.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in = new BufferedReader(new StringReader(src));
        int T = Integer.parseInt(in.readLine());

        for(int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(in.readLine());

            map = new int[n][n];
            visited = new boolean[n];


            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bfs(0);
            System.out.println();
        }
    }

    private static void bfs(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(cur);
        visited[cur] = true;

        while (!queue.isEmpty()) {
            cur = queue.poll();
            System.out.printf("%c", cur + 65);

            for(int adj = 0; adj < n; adj++) {
                if(map[cur][adj] == 1 & !visited[adj]) {
                    queue.offer(adj);
                    visited[adj] = true;
                }
            }

        }
    }
    static String src = "2\n" +
            "4\n" +
            "0 1 0 1\n" +
            "1 0 1 1\n" +
            "0 1 0 1\n" +
            "1 1 1 0 \n" +
            "6\n" +
            "0 1 0 1 0 0\n" +
            "1 0 1 0 1 0 \n" +
            "0 1 0 0 1 1\n" +
            "1 0 0 0 0 1\n" +
            "0 1 1 0 0 1\n" +
            "0 0 1 1 1 0\n" ;
}
