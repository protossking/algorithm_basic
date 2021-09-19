package 알고리즘이론.디피;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_9205_맥주마시면서걸어가기 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());

        for(int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(in.readLine());
            int[][] dist = new int[n+2][n+2];
            boolean[][] d = new boolean[n+2][n+2];
            List<int[]> point = new ArrayList<>();
//            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int i = 0; i < n+2; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                point.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }
            for(int i = 0; i < n+2; i++) {
                for(int j = 0; j < n+2; j++) {
                    int[] p1 = point.get(i);
                    int[] p2 = point.get(j);
                    dist[i][j] = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);

                    if(dist[i][j] <= 50 * 20) //최대20개 50미터마다 1병씩
                        d[i][j] = true;
                }

            }

            for(int k = 0; k < n+2; k++) { //경
                for(int i = 0; i < n+2; i++) { // 출
                    for(int j = 0; j < n+2; j++) { // 도
                        if(d[i][k] & d[k][j])
                            d[i][j] = true;
                    }
                }
            }
            System.out.println(d[0][n+1] ? "happy" : "sad");
        }
    }
}
