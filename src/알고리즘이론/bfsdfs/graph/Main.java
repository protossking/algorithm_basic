package 알고리즘이론.bfsdfs.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int col;
    static int row;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1 ,0 , 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        visited = new boolean[row][col];

        for(int i =0; i < row; i++) {
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j <col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i =0 ; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }

            }
        }

    }
    static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

    }
}
