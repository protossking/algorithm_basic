package 알고리즘이론.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정올_3517_이진탐색 {

    static int N;
    static int[] a;
    static int Q;
    static int[] b;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();
        a = new int[N];


        for(int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Q = Integer.parseInt(in.readLine());
        b = new int[Q];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < b.length; i++) {
            b[i] =  Integer.parseInt(st.nextToken());
        }

//        int i = binarySearchRecur(a, a[0], a[a.length - 1], b[0]);
        for(int i = 0; i < Q; i++) {

            int ans = binarySearchRecur(a, 0, N-1, b[i]);
            sb.append(ans).append(" ");

        }
        System.out.println(sb.toString());


    }
    static int binarySearchRecur(int[] arr, int low, int high, int target) {
        if(low > high) {
            return -1;
        }
        int mid = (low + high) / 2;

        if(arr[mid] == target) {
            return mid;
        }
        if(arr[mid] > target) {
            return binarySearchRecur(arr, low, mid-1, target);
        }
        return binarySearchRecur(arr, mid+1, high, target);

    }

}
