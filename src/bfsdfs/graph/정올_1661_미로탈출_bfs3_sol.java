package bfsdfs.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
        1. 레벨 수 세기
        2. int[} {r, c, d} d는 거리
        3. map 에 이동거리 저장 --> 방문처리

        입력값을 -1 씩하거나 배열크기를 + 1로 함
         */

public class 정올_1661_미로탈출_bfs3_sol {

    static int[][] map;

    static int colN, rowN, sr, sc, er, ec;


    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        in = new BufferedReader(new StringReader(inputdata));


        StringTokenizer st = new StringTokenizer(in.readLine());
        colN = Integer.parseInt(st.nextToken());
        rowN = Integer.parseInt(st.nextToken());

        map = new int[rowN][colN];


        //좌표가 1,1 부터 시작하므로 시작하는 좌표 -1씩 해서 0,0 에서 시작하는 좌표로 변경
        st = new StringTokenizer(in.readLine(), " ");
        sc = Integer.parseInt(st.nextToken()) - 1;
        sr = Integer.parseInt(st.nextToken()) - 1;
        ec = Integer.parseInt(st.nextToken()) - 1;
        er = Integer.parseInt(st.nextToken()) - 1;

        //맵 정보 입력 받기
        for (int i = 0; i < rowN; i++) {
            String line = in.readLine();
            for (int j = 0; j < colN; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        bfs();
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        //시작점 위치 , 거리
        queue.offer(new int[]{sr, sc, 0});
        map[sr][sc] = 1; // 방문 처리 및 거리 표사ㅣ


        int r, c, nr, nc, dist ;
        top:
        while (!queue.isEmpty()) {

            //레벨별 node 처리 queue 사이즈 만큼 돌림

            int[] cur = queue.poll();
            r = cur[0];
            c = cur[1];
            dist = map[r][c];
            for (int j = 0; j < 4; j++) { // 인접노드 상하좌우 처리
                nr = r + dr[j];
                nc = c + dc[j];
                if (nr > -1 && nr < rowN && nc > -1 && nc < colN && map[nr][nc] == 0 ) { //경계내인지비교

                    if (nr == er && nc == ec) {
//                                break top;
                        System.out.println(dist);
                        return;
                    }
                    map[nr][nc] = dist+1;
                    queue.offer(new int[]{nr, nc});


                }
            }


        }
    }


    static String inputdata = "8 7\n" +
            "1 2 7 5\n" +
            "11111111\n" +
            "00000111\n" +
            "10110011\n" +
            "10111001\n" +
            "10111101\n" +
            "10000001\n" +
            "11111111";
}
