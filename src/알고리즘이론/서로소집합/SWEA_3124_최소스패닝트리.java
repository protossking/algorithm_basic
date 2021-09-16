package 알고리즘이론.서로소집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3124_최소스패닝트리 {

    static class Edge implements Comparable<Edge> {

        int start,  end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int V, E;
    static Edge[] edgeList;
    static int[] parents; // 부모 원소를 관리

    private static void make() {
        parents = new int[V];
        for (int i = 0; i < V; i++) {
            parents[i] = i;
        }
    }

    private static int find(int a) {
        if (a == parents[a])
            return a;
        return parents[a] = find(parents[a]);
    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(in.readLine());
            V = Integer.parseInt(st.nextToken()) ;
            E = Integer.parseInt(st.nextToken()) ;

            edgeList = new Edge[E];

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(in.readLine());
                int start = Integer.parseInt(st.nextToken()) -1;
                int end = Integer.parseInt(st.nextToken()) -1 ;
                ;
                int weight = Integer.parseInt(st.nextToken());
                edgeList[i] = new Edge(start, end, weight);
            }
            Arrays.sort(edgeList); // 오름차순 정렬

            make(); // 모든 정점을 각각의 집합으로 만들고 출발
            //간선 하나씩 시도하며 트리 만들어감
            int cnt = 0;
            long result = 0; // 최소비용
            for (Edge edge : edgeList) {
                if (union(edge.start, edge.end)) {
                    result += edge.weight;
                    if (++cnt == V - 1) break; // 신장트리 완성
                }
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");



        }
        System.out.println(sb.toString());
    }
}
