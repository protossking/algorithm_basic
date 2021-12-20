package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1920_수찾기 {

    public static void main(String[] args) throws IOException {

        BufferedReader inn = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inn.readLine());
        StringTokenizer st = new StringTokenizer(inn.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(inn.readLine());

        int[] arr2 = new int[M];
        st = new StringTokenizer(inn.readLine());

        for(int i = 0 ; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr2.length; i++) {
            if(binarySearch(arr, arr2[i])) {
                sb.append("1");
            }
            else {
                sb.append("0");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());



    }

    static boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if(arr[mid] == target) {
                return true;
            }
            else if(arr[mid] < target) {
                start = mid + 1;
            }
            else if(arr[mid] > target) {
                end = mid - 1;
            }
        }
        return false;
    }
}
