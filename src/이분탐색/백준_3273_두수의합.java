package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_3273_두수의합 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());

        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(in.readLine());
        int ans = 0; // res 빼기
        Arrays.sort(arr);

        for(int i = 0; i < arr.length-1; i++) {
            if(binarySearch(arr, x - arr[i], i+1, arr.length-1)){
                ans ++;
            }
        }
        System.out.println(ans);


    }

    static boolean binarySearch(int[] arr, int target, int L, int R) {
        int res = L - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if(arr[mid] == target) {
                return true;
            }
            if (arr[mid] < target) {
                L = mid + 1;

            }
            else {
                R = mid - 1;
            }
        }
        return false;
    }
}
