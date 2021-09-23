package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
    1. 가장자리가 아닌 코어를 리스트에 담기
    2. 코어리스트로 부분집합처리하여 시도해볼 코어 선택
    3. 선택된 코어마다 4방향 전선놓기 시도
 */

public class SWEA_무선충전 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int N;
    static int map[][];
    static int max; // 연결한 최대 코어수
    static int min; // 최소전선 길이의 합
    static int totalCnt;

    static ArrayList<int[]> list; // 가장자리가 아닌 코어들의 위치를 저장한 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(in.readLine());
        for(int tc = 1; tc <= TC; tc ++) {
            N = Integer.parseInt(in.readLine());
            map = new int[N][N];
            list = new ArrayList<>();
            max = 0;
            min = Integer.MAX_VALUE;
            totalCnt = 0;

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine(), " ");
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    // 가장자리 코어는 저장하지 않는다.
                    if(i == 0 || i == N-1 || j == 0 || j == N-1) continue;
                    if(map[i][j] == 1) {
                        list.add(new int[]{i,j});
                        totalCnt ++; // 가장 자리가 아닌 코어 개수
                    }
                }
            }
            go(0,0);
            System.out.println("#" + tc + " " + min);
        }



    }

    private static void go(int index, int cCnt) {

        if(index == totalCnt) {
            int res = getLength();
            //선택된 코어 개스로 max 갱신
            if(max > cCnt) {
                max = cCnt;
            }else if(max == cCnt) { // 코어 개수가 같으면 최소길이의합
                if(min> res) min = res;
            }
            return ;
        }



        int[] cur = list.get(index);
        int r = cur[0];
        int c = cur[1];

        //index 코어 선택 : 4방향 시도
        for(int d = 0; d < 4; d++ ) {
            if(isAvailable(r,c,d)) {
                // 전선 놓기
                setStatus(r,c,d, 2);
                // 다음 코어로
                go(index+1, cCnt+1);
                // 놓았던 전선 지우기
                setStatus(r,c,d,0);

            }
        }

        // index 코어 미선택
        go(index+1, cCnt);
    }
    static void setStatus(int r, int c, int d, int s) {
        int nr = r;
        int nc = c;
        while (true) {
            nr += dr[d];
            nc += dc[d];
            if(nr<0 || nr >= N || nc < 0 || nc>= N) break;
            map[nr][nc] = s;
        }
    }


    static boolean isAvailable(int r, int c, int d) {
        int nr = r, nc = c;
        while (true) {
            nr += dr[d];
            nc += dc[d];
            if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
            if(map[nr][nc] >= 1) return false;
        }
        return true;
    }

    private static int getLength() {
        int res = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] > 1) res ++;
            }
        }
        return res;
    }
}
