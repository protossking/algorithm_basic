package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    정점:학생, 간선 학생간의 키 비교 결과
    완전그래프 -> 하나의 정점에서 다른 모든 정점과 연결되어있는 그래프
    유향 그래프 탐색 1보다 큰 학생따라 탐색 -> 카운팅 -> 1보다 큰 학생수  -> 1보다 작은학생따라 탐색
 */
public class SWEA_5643_키순서 {

    static int N, M, adj[][];

    static int gtCnt, ltCnt;


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(in.readLine()); // 학생수
            M = Integer.parseInt(in.readLine()); // 간선정보 수
            adj = new int[N + 1][N + 1];
            StringTokenizer st = null;
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(in.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adj[from][to] = 1; // from  보다 to 가 키가 크다
            }
            int ans = 0;
            for (int i = 1; i <= N; i++) {
                if (bfs(i) + ltbfs(i) == N - 1) ans++;
            }
            int ans2 = 0;
            System.out.println("#" + tc + " " + ans);

            for (int i = 1; i <= N; i++) {
                gtCnt = ltCnt = 0;
                gtDfs(i, new boolean[N + 1]);
                ltDfs(i, new boolean[N + 1]);
                if (gtCnt + ltCnt == N - 1) ans2++;
            }
            System.out.println("#" + tc + " " + ans2);

            int ans3 = 0;
            //위에서 탐색된 결과를 토대로 자신보다 작은 학생수 카운팅
            for(int i =1; i <= N; i++) {
                if(adj[i][0] != -1) dfs(i);
            }
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <=N; j++) {
                    adj[0][j] += adj[i][j];
                }
            }
            for(int i = 1; i <= N; i++) {
                if(adj[i][0] + adj[0][i] == N-1) ans3++;
            }
            System.out.println("#" + tc + " " + ans3);
        }
    }

    // 자신보다 큰 학생따라 탐색
    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(start);
        visited[start] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 1; i <= N; i++) { // 행단위로
                if (!visited[i] && adj[cur][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        return cnt;

    }

    static int ltbfs(int start) { // 자신보다 작은학생따라 탐색
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(start);
        visited[start] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 1; i <= N; i++) { // 행단위로
                if (!visited[i] && adj[i][cur] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        return cnt;

    }

    static void gtDfs(int cur, boolean[] visited) {
        visited[cur] = true;


        for (int i = 1; i <= N; i++) {
            if (!visited[i] && adj[cur][i] == 1) {
                visited[i] = true;
                gtCnt++;
                gtDfs(i, visited);
            }
        }
    }

    static void ltDfs(int cur, boolean[] visited) {
        visited[cur] = true;


        for (int i = 1; i <= N; i++) {
            if (!visited[i] && adj[i][cur] == 1) {
                visited[i] = true;
                ltCnt++;
                ltDfs(i, visited);
            }
        }
    }

    static void dfs(int cur) {
        for(int i = 1; i <= N; i++) {
            if(adj[cur][i] == 1) { // 자신보다 큰 학생이면
                if(adj[i][0] == -1) { // 탐색전
                    dfs(i);
                }
                //자신보다 큰 학생을 탐색을 완료한 상태 ( 메모가 되어있으면 탐색안하고 바로 내려옴 )
                if(adj[i][0] > 0) { //i 보다 큰 학생이 존재
                    // i 의 인접 행렬의 상태를 cur 에 반영
                    for(int j = 1; j <= N; j++) {
                        if(adj[i][j] == 1) adj[cur][j] = 1;
                    }
                }

            }
        }
        int cnt = 0;
        for(int j = 0; j <= N; j++ ){
            cnt += adj[cur][j];

        }
        adj[cur][0] = cnt;
    }
}
