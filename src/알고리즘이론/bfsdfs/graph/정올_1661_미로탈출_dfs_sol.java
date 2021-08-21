package 알고리즘이론.bfsdfs.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
        1. 레벨 수 세기
        2. int[} {r, c, d} d는 거리
        3. map 에 이동거리 저장 --> 방문처리

        입력값을 -1 씩하거나 배열크기를 + 1로 함
         */

public class 정올_1661_미로탈출_dfs_sol {

    static int[][] map;
    static boolean[][] visited;
    static int colN, rowN, sr, sc, er, ec;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in = new BufferedReader(new StringReader(inputdata));


        StringTokenizer st = new StringTokenizer(in.readLine());
        colN = Integer.parseInt(st.nextToken());
        rowN = Integer.parseInt(st.nextToken());

        map = new int[rowN][colN];
        visited = new boolean[rowN][colN];

        //좌표가 1,1 부터 시작하므로 시작하는 좌표 -1씩 해서 0,0 에서 시작하는 좌표로 변경
        st = new StringTokenizer(in.readLine());
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
        dfs(sr, sc, 0);
        System.out.println(min);
    }

    private static void dfs(int r, int c, int dist) {
        //기저 조건
        if(r == er && c == ec) {
            //도착 지점 까지 온 상태
            min = Math.min(min, dist);
            return;
        }

        //방문 체크
        visited[r][c] = true;
        int nr = 0, nc = 0;
        for(int i = 0; i < dc.length; i++) {
            nr = r + dr[i];
            nc = c + dc[i];
            if(nr > -1 && nr <= rowN &&  nc > -1 && nc <=colN && map[nr][nc] == 0 && !visited[nr][nc]) { //경계내에 있음.
                dfs(nr, nc, dist + 1);
            }
        }
        //이 재귀가 끝나면 다른 경로를 통해서 이동함으로 현재 r, c는 안간길
        visited[r][c] = false;

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


    static String inputData2="5 5\r\n" +
            "1 1 5 5\r\n" +
            "00000\r\n" +
            "01101\r\n" +
            "00100\r\n" +
            "01110\r\n" +
            "00000";
}
