package d1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_단어정렬 {



    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());
        List<String> list =new ArrayList<>();
        String[] arr = new String[T];
        for(int tc = 0; tc < T; tc++) {
                arr[tc] = in.readLine();
        }


        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                else {
                    return o1.length() - o2.length();
                }
            }
        });
        System.out.println(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(!arr[i].equals(arr[i-1])) {
                System.out.println(arr[i]);
            }
        }


    }
}
