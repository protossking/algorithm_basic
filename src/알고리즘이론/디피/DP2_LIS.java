package 알고리즘이론.디피;

import java.util.Scanner;

public class DP2_LIS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] LIS = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 0;
        for(int i = 0; i < N; i++) {
            LIS[i] = 1;

            for(int j = 0; j < i; j++) { // j : i 의 앞쪽원소
                if(arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                }
                // i 를 끝으로 하는 최장길이 값 계산 완료
            }
            if(max<LIS[i]) max = LIS[i];
        }
        System.out.println(max);
    }
}
