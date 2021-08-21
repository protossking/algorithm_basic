package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;

/*
    케이크 크기의 배열선언
    예상되는 사람은 입력된값의 차이 만큼 계산 한다
    실제로 많이 받는사람은
    첫번째 사람의 입력값은 1로 다 채운다

 */
public class 백준_3985_롤케이크 {

    static int[] arr;
    static int[] arr2;
    static int expect;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st;
        arr = new int[N];

        int T = Integer.parseInt(in.readLine());
        int maxExpected = Integer.MIN_VALUE;
        arr2 = new int[T+1];

        for(int i = 1; i <= T; i++) {
            st = new StringTokenizer(in.readLine());
            int start = Integer.parseInt(st.nextToken()) -1;
            int end = Integer.parseInt(st.nextToken()) -1;
            if(maxExpected < end-start) {
                maxExpected = end-start;
                expect = i;
            }
            for(int j = start; j <= end; j++) {
                if(arr[j] == 0) {
                    arr[j] = i;
                    arr2[i] ++;
                }
            }

        }
        int maxreal = arr2[0];
        int index =0 ;
        for(int i = 1; i < arr2.length; i++) {
            if(maxreal < arr2[i]) {
                maxreal = arr2[i];
                index = i;
            }
        }
        System.out.println(expect);
        System.out.println(index);



    }
}
