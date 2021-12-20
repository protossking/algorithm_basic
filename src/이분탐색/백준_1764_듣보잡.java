package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1764_듣보잡 {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] hear = new String[N];
        String[] see = new String[M];

        for(int i = 0; i < hear.length; i++) {
            hear[i] = in.readLine();
        }
        for(int i = 0; i < see.length; i++) {
            see[i] = in.readLine();
        }

//        System.out.println(Arrays.toString(hear));
//        System.out.println(Arrays.toString(see));

        Arrays.sort(hear);
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < see.length; i++) {
            if(binarySearch(hear, see[i])) {
                list.add(see[i]);
                count ++;

            }

        }
        System.out.println(count);
        Collections.sort(list);
        for(String s: list) {
            System.out.println(s);
        }

    }



    static boolean binarySearch(String[] arr, String target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid].equals(target)) {
                return true;
            }

            if(arr[mid].compareTo(target) < 0) {
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return false;
    }
}
