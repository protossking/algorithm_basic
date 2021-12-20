package d1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_빙고 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[5][5];
        int bingo = 0;
        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 0; j < 5; j++) {
                arr[i][j] =Integer.parseInt(st.nextToken());


            }
        }
        int answer = 0;
        top:
        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 0; j < 5; j++) {
                int k = Integer.parseInt(st.nextToken());
                answer ++;
                for(int a = 0; a < arr.length; a++) {
                    for (int b = 0; b < arr.length; b++) {
                        if(arr[a][b] == k) {
                            arr[a][b] = -1;
                            int c = colB(arr) + rowB(arr) + diagonalB1(arr) + diagonalB2(arr);
                            if(c >= 3) {

                                break top;
                            }else {
                                bingo = 0;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);

//        for(int i = 0; i <arr.length; i++) {
//            for(int j = 0; j < arr.length; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }

    }


    static int colB(int[][] arr) {
        int count;
        int a = 0;
        for(int i = 0; i < arr.length; i++) {
            count = 0;
            for(int j = 0; j < arr.length; j++) {
                if(arr[i][j] == -1) {
                    count ++;
                    if(count == 5) {
                        a++;

                    }
                }


            }
        }
        return a;
    }


    static int rowB(int[][] arr) {
        int count;
        int a = 0;
        for(int i = 0; i < arr.length; i++) {
            count = 0;
            for(int j = 0; j < arr.length; j++) {
                if(arr[j][i] == -1) {
                    count ++;
                    if(count == 5) {
                        a++;
                    }
                }


            }
        }
        return a;
    }

    static int diagonalB1(int[][] arr){
        int count=0;
        int a = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i][i] == -1) {
                count++;
                if(count == 5) {
                    a++;
                }
            }
        }
        return a;
    }

    static int diagonalB2(int[][] arr){
        int count=0;
        int a = 0;
        for(int i = 4; i >= 0; i--) {
            if(arr[4-i][i] == -1) {
                count++;
                if(count == 5) {
                    a++;
                }
            }
        }
        return a;
    }

}
