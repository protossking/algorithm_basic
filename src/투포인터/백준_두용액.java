package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_두용액 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int v1 = 0;
        int v2 = 0;
        int left = 0;
        int right = N-1;
        int best_sum = Integer.MAX_VALUE;

        //최소 + 최대 < 0
        //최소 + 최대 > 0
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        while (left < right) {
            int sum = arr[left] + arr[right];
            if(Math.abs(sum) < best_sum) {
                best_sum = Math.abs(sum);
                v1 = arr[left];
                v2 = arr[right];
            }

            if(sum > 0) {
                right --;
            }
            else {
                left ++;
            }
        }
        sb.append(v1).append(" ").append(v2);
        System.out.println(sb.toString());




    }


}
