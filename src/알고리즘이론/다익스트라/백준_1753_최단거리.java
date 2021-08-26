package 알고리즘이론.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1753_최단거리 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(in.readLine()) -1;
        int[][] map = new int[V][V];
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int w= Integer.parseInt(st.nextToken());
            map[r][c] = w;
        }
//        System.out.println(Arrays.deepToString(map));

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        int min = 0;
        int cur = 0;
        for(int i = 0; i < V; i++) {
            min = Integer.MAX_VALUE;

            for(int j = 0; j < V; j++) {
                if(!visited[j] && min > distance[j]) {
                    min = distance[j];
                    cur = j;
                }
            }
            visited[cur] = true;
            for(int j = 0; j < V; j++) {
                if(!visited[j] && map[cur][j] != 0 && distance[j] > min + map[cur][j]) {
                    distance[j] = min + map[cur][j];
                }
            }
        }
        for(int i = 0; i < distance.length; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else {
                System.out.println(distance[i]);
            }

        }
//        System.out.println(Arrays.toString(distance));




    }
}
