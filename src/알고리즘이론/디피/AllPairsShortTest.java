package 알고리즘이론.디피;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    플로이드 워셜
    - 모든 정점에 대한 최소비용(최단거리) 구하는 알고리즘
    - 성능 O (n^3)
    - 정점이 400개면 1초 내라서 안전
    - 정점이 500개 이상이면 안ㄷ뫼
 */
public class AllPairsShortTest {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[][] map = new int[N][N];
        int max = Integer.MAX_VALUE>>2;

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(i != j && map[i][j] == 0) { // 두 정점은 연결되지 않았기 때문에 max 값으로 표시
                    map[i][j] = max;
                }
            }
        }

        for(int k = 0; k < map.length; k++) { // 경유지
            for(int i = 0; i < N; i++) { // 출발지
//                if(i == k ) continue; // 경유지와 출발지가 같은 경우 굳이 갱신할 필요 없게 ... => 정점이 많아지면 if 비교를 많이 하므로 성능 저하
                for(int j = 0; j < N; j++) { // 도착지
//                    if(i == j || k == j)  continue; //도착지와 출발지가 같거나 , 경유지와 도착지가 같은 경우 굳이 갱신할 필요 없게 -> 성능저하
//                        이전 경유지비용 현 경유지 비용  // 이전 경유지 비용보다 현 경유지를 거쳐가는 비용이 더 저렴하다면
                    if(map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j]  = map[i][k] + map[k][j]; // 갱신하기
                    }
                }
            }
        }

        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

    }
}
