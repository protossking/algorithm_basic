package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_무선충전 {

    static class AP{
        int y;
        int x;
        int c;
        int p;
        public AP (int y, int x, int c, int p){
            this.y = y;
            this.x = x;
            this.c = c;
            this.p = p;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        for(int tc = 1; tc<=T; tc++) {

            StringTokenizer st = new StringTokenizer(in.readLine());
            int M = Integer.parseInt(st.nextToken()); // 총 시간
            int A = Integer.parseInt(st.nextToken()); // BC의 개수

            int[] aInfo = new int[M];
            int[] bInfo = new int[M];
            st = new StringTokenizer(in.readLine());
            for(int i = 0; i < aInfo.length; i++) {
                aInfo[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 0; i < aInfo.length; i++) {
                bInfo[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<AP> aps = new ArrayList<>();
            for(int i  = 0; i < A; i++) {
                st = new StringTokenizer(in.readLine());

                aps.add(new AP(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));


            }

        }


    }
}
