package 따로저장.d1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_S1_숨바꼭질 {

    static int N;
    static int K;

    static int[] map;
    static boolean[] visited;


    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[100001];
        visited = new boolean[100001];
        count = 1;


        if( N == K) {
            System.out.println("0");
        }else {
            bfs(N);
        }


    }

    static void bfs(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(cur);
        visited[cur] = true;

        while (!queue.isEmpty()) {

            int r = queue.poll();
            count ++;
            for(int adj = 0; adj < 3; adj++) {

                int nr;
                if(adj == 0) {
                    nr = r + 1;
                }
                else if(adj == 1) {
                    nr = r -1;
                }
                else {
                    nr = r *2;
                }

                if(nr == K) {
                    System.out.println(map[r] + 1);
                    return;
                }
                if(nr > -1 && nr < 100001 && !visited[nr]) {
                    queue.offer(nr);
                    map[nr] = map[r] + 1;
                    visited[nr] = true;

                }

            }


        }
    }
}


/*

 */