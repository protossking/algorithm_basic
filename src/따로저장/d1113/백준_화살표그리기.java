package 따로저장.d1113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_화살표그리기 {

    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        list = new ArrayList[N+1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Integer>();

        }
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[b].add(a);
        }



        for(int i = 1; i <= N; i++) {
            Collections.sort(list[i]);

        }
        int ans = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < list[i].size(); j++) {
                //right 까지 수
                int right = rightV(j,i);
                //left 까지수
                int left = leftV(j,i);

                ans += Math.min(right, left);
            }
        }
        System.out.println(ans);


    }

    static int leftV(int idx, int color) {
        if(idx == 0) return Integer.MAX_VALUE;
        int i = list[color].get(idx) - list[color].get(idx - 1);
        return i;
    }

    static int rightV(int idx, int color) {
        if(idx +1 == list[color].size()) return Integer.MAX_VALUE;
        return list[color].get(idx+1) - list[color].get(idx);


    }

}
