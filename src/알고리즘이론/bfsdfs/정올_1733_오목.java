package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정올_1733_오목 {

    static int[][] map;
    static int[][] deltas = {
            {-1, 1},
            {0, 1},
            {1, 1},
            {1, 0}

    };

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        map = new int[20][20]; // 1부터 시작하니 20개 자리로
        for(int r= 1; r < 20; r++) {
            st = new StringTokenizer(in.readLine());
            for(int c = 1; c < 20; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r= 1; r < 20; r++) {
            for(int c= 1; c < 20; c++) {
                if(map[r][c]!=0) {
                    //가능한 방향으로 살펴보기
                    for(int d = 0; d < deltas.length; d++) {
                        int nr = r - deltas[d][0];
                        int nc = c - deltas[d][1]; // 반대방향 살펴보기
                        //범위내에 있고 반대방향의 값이 나랑 달라야한다 .
                        if(isIn(nr,nc) && map[nr][nc] == map[r][c]) {
                            continue;
                        }
                        //그렇지않다면 찾아보기 정확히 5개 나와야 성공
                        int result = find(r,c,d);
                        if(result == 5) {
                            System.out.println(map[r][c] + "\n" + r +" " + c);
                        }
                    }
                }
            }
        }
    }
    static int find (int r, int c, int d) {
        int cnt = 0;
        while(cnt < 6) {
            int nr = r + deltas[d][0]*cnt;
            int nc = c + deltas[d][0]*cnt;
            //범위, 값 확인
            if(!(isIn(nr , nc) && map[r][c] == map[nr][nc])) {
                break;
            }
            //연속되면 cnt ++
            cnt++;
        }
        return cnt;
    }

    static boolean isIn(int r, int c) {
        return 0 < r && r< 20 && 0 < c && c < 20;

    }
}
