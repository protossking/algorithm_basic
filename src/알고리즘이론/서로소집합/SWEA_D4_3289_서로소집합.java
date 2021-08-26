package 알고리즘이론.서로소집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_3289_서로소집합 {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for(int tc =1 ; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr = new int[n+1];
            for(int i = 1; i <= n; i++) {
                arr[i] = i;
            }
            for(int i = 0 ; i < m; i++) {
                st = new StringTokenizer(in.readLine());
                int kind = Integer.parseInt(st.nextToken());
                int a =  Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(kind == 1) {
                    if(find(arr, a, b)) System.out.println(1);

                } else {
                    union(arr, a, b);
                }
            }
            System.out.println();
        }
    }

    public static int findSet(int[] p, int x) {
        if(x == p[x]) return x;
        else return p[x] = findSet(p, p[x]);
    }
    public static void union(int[] p, int x, int y) {
        x = findSet(p, x);
        y = findSet(p, y);

        if(x > y) p[x] = y;
        else p[y] = x;
    }
    public static boolean find(int[] p, int x, int y) {
        return (findSet(p, x) ==findSet(p, y));
    }

}
