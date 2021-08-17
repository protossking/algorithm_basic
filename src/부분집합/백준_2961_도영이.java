package 부분집합;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_2961_도영이 {
    static int[] sour;
    static int[] bitter;
    static boolean[] isSelected;
    static int N;

    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sour = new int[N];
        bitter = new int[N];
        isSelected = new boolean[N];
        for (int i = 0; i < N; i++) {
            sour[i] = sc.nextInt();
            bitter[i] = sc.nextInt();
        }
        //입력 완료
        answer = Integer.MAX_VALUE;
        subset2(0);
        System.out.println(answer);

    }

    static void subset2(int cnt) {
        boolean isZero = false;
        if (cnt == N) {
            int sumS = 1;
            int sumB = 0;

            for (int i = 0; i < N; i++) {
                if(isSelected[i]) {
                    sumS *= sour[i];
                    sumB += bitter[i];
                    isZero = true;

                }
            }
            if(!isZero) return;



            answer = Math.min(answer, Math.abs(sumS-sumB));

            System.out.println();
            return;
        }
        isSelected[cnt] = true;
        subset2(cnt + 1);
        isSelected[cnt] = false;
        subset2(cnt + 1);
    }


//    static void subset(int cnt) {
//        if(cnt == N) {
//            for(int i = 0; i < N; i++) {
//                int i1 = sour[i] * i;
//
//            }
//        }
//        isSelected[cnt] = true;
//        subset(cnt + 1);
//        isSelected[cnt] = false;
//        subset(cnt + 1);
//
//    }
}
