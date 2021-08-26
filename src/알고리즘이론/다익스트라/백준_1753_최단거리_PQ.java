package 알고리즘이론.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_1753_최단거리_PQ {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(in.readLine()) -1;

        boolean[] visited = new boolean[V];
        ArrayList<Node> list[] = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            list[i] = new ArrayList<>();
        }
        int[] distance = new int[V];
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int w= Integer.parseInt(st.nextToken());

            list[r].add(new Node(c,w));
        }
//        System.out.println(Arrays.deepToString(map));

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            if(visited[n.node]) {
                continue;
            }
            visited[n.node] = true;
            for(Node a : list[n.node]) {
                if(distance[a.node] > distance[n.node] + a.w) {
                    distance[a.node] = distance[n.node] + a.w;
                    queue.add(new Node(a.node, distance[a.node]));
                }
            }
        }
        for(int i = 0; i < V; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }





    }

    static class Node implements Comparable<Node> {
        int node, w;

        public Node(int node, int w) {
            this.node = node;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}
