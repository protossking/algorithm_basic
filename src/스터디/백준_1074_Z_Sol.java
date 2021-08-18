package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1074_Z_Sol {
        static int N;
        static int R;
        static int C;
        static int count = 0 ;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);


//        divide2(size, R, C);
        divide(0, 0, size);
        System.out.println(count);

    }
    static void divide(int nr, int nc, int size) {
        if (size == 1) {
            return;
        }

        if (R < nr + size / 2 && C < nc + size / 2) {
            divide(nr, nc, size / 2);
        }


        else if (R < nr + size / 2 && C < nc + size) {
            divide(nr, nc + size / 2, size / 2);
            count +=(size * size /4);
        }


        else if (R < nr + size && C < nc + size / 2){
            divide(nr + size / 2, nc, size / 2);
            count +=(size * size /4) * 2;
        }
        else {
            divide(nr + size / 2, nc + size / 2, size / 2);
            count +=(size * size /4) * 3;
        }

    }

    private static void divide2(int size, int r, int c) {
        if (size == 1)
            return;

        if (r < size / 2 && c < size / 2) {
            divide2(size / 2, r, c);
        } else if (r < size / 2 && c >= size / 2) {
            count += size * size / 4;
            divide2(size / 2, r, c - size / 2);
        } else if (r >= size / 2 && c < size / 2) {
            count += (size * size / 4) * 2;
            divide2(size / 2, r - size / 2, c);
        } else {
            count += (size * size / 4) * 3;
            divide2(size / 2, r - size / 2, c - size / 2);
        }

    }


}
