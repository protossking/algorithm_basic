package 따로저장.d1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정올_2577_회전초밥 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());


        int[] dish = new int[N];
        int[] kind = new int[d+1];


        for(int i = 0; i < N; i++) {
            dish[i] = Integer.parseInt(in.readLine());
        }

        int ans = 0;
        int count = 0;

        for(int i = 0; i < k; i++) {
            if(kind[dish[i]] == 0) count ++;
            kind[dish[i]] ++;
        }

        ans = count;

        for(int i = 1; i < N; i++) {
            if(ans <= count) {
                if(kind[c] == 0) ans = count + 1;
                else ans = count;
            }

            kind[dish[i-1]] --;
            if(kind[dish[i-1]] == 0) count --;

            if(kind[dish[(i+k -1 ) % N]] == 0) count ++;
            kind[dish[(i+k-1) % N]]++;
        }




        System.out.println(ans);
    }
}
