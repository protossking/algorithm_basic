package 알고리즘이론.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA_3234_준환이의양팔저울 {

    static int[] w;
    static boolean[] selected;
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader in = new BufferedReader(new StringReader(src));
        int T = Integer.parseInt(in.readLine());
        StringTokenizer st;

        for(int tc = 1; tc<= T; tc++) {
            N = Integer.parseInt(in.readLine());
            w = new int[N];
            count = 0;
            selected = new boolean[N];

            st = new StringTokenizer(in.readLine());

            for(int i = 0; i < N; i++) {
                w[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0,0,0);
            System.out.println(count);

        }
    }
    static void dfs(int cnt,  int left, int right) {
        if(cnt == N) {
            count++;
            return;
        }

        for(int i =0 ; i < N; i++) {
            if(selected[i]) continue;
            selected[i] = true;
            dfs(cnt + 1, left + w[i], right);
            dfs(cnt+1 , left, right + w[i]);
            selected[i] = false;
        }
    }

    static String src = "3\n" +
            "3\n" +
            "1 2 4\n" +
            "3\n" +
            "1 2 3\n" +
            "9\n" +
            "1 2 3 5 6 4 7 8 9";
}
