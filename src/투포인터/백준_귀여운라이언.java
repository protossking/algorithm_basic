package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_귀여운라이언 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        int left = 0;
        int right = -1;
        int sum = 0;
        int ans = -1;

        for(int left = 0; left < N; left ++) {

            while (right < N -1 && sum < K) {
                right++;
                if(arr[right] == 1) sum ++;

            }
            if(sum == K) {
                if(ans == -1) ans = right - left + 1;
                ans = Math.min(ans, right - left + 1);
            }
            if(arr[left] == 1) {
                sum --;
            }

        }
        System.out.println(ans);
    }
}
