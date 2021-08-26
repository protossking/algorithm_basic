package 알고리즘이론.PrimPQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_D4_1251_하나로 {

    static Land[] lands;


    static class Land {
        int x;
        int y;

        public Land(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Vertex implements Comparable<Vertex> {
        int node;
        long weight;

        public Vertex(int node, long weight) {
            this.node = node;
            this.weight = weight;
        }

//        @Override
//        public int compareTo(Vertex o) {
//            return 0;
//        }

        @Override
        public int compareTo(Vertex o) {
            return  Long.compare(weight, o.weight);
//        }
    }
    static long[][] map;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new  BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(in.readLine());

            lands = new Land[N];
            map = new long[N][N];
            visited = new boolean[N];
            StringTokenizer st = new StringTokenizer(in.readLine());

            for(int i = 0; i < N; i++) {
                lands[i] = new Land(0, 0);
                lands[i].x = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(in.readLine());
            for(int i = 0; i < N; i++) {
                lands[i].y = Integer.parseInt(st.nextToken());
            }
//            double E = Integer.parseInt(in.readLine());
            double E = Double.parseDouble(in.readLine());

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    long l =  (long)(calDis(lands[i].x, lands[i].y, lands[j].x, lands[j].y) * E);
                    map[i][j] = l;

                }
            }
//            System.out.println(Arrays.deepToString(map));

            long[] minEdge = new long[N];
            for(int i = 0; i < map.length; i++) {
                minEdge[i] = Long.MAX_VALUE;
            }
            int start = 0;
            long result = 0;
            long nodeCount =0;
            PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
            queue.offer(new Vertex(start, 0));
            minEdge[ start] = 0;

            while(!queue.isEmpty()) {
                Vertex min = queue.poll();
                if(visited[min.node]) continue;

                result += min.weight;
                visited[min.node] = true;
                if(++nodeCount == N) break;


                for(int i = 0; i < N; i++) {
                    if(!visited[i] && map[min.node][i] != 0 && minEdge[i] > map[min.node][i]) {
                        minEdge[i] =  map[min.node][i];
                        queue.offer(new Vertex(i,  map[min.node][i]));
                    }
                }
            }

//            System.out.println("#" + tc +" "+result);
            sb.append("#").append(tc).append(" ").append(result).append("\n");

        }
        System.out.println(sb);
    }

    static long calDis(long x1, long y1, long x2, long y2) {
        return ((x2 - x1)*(x2 - x1)) + ((y2-y1) * (y2-y1));
    }
}}
