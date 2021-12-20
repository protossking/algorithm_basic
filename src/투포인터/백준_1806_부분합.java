package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1806_부분합 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());


        int[] arr = new int[N];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int ans = N+1;
        int sum = 0;

        while (true){
            if(sum >= S) {
                sum -= arr[left++];
                ans = Math.min(ans, right - left + 1);
            }
            else if (right == N) break;
            else{
                sum += arr[right++];
            }
        }
        if(ans == N+1) {
            ans = 0;
        }
        System.out.println(ans);

    }
}
