package 따로저장.d1027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;

    static int[] sum;
    static List<Integer> list;
    static int[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        map = new int[N+1][N+1];

        sum = new int[5];
        for(int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 1; j < N+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new int[N+1][N+1];
        list =  new ArrayList<>();

        for(int i = 1; i < N+1; i++) {
            for(int j = 1; j < N+1; j++) {
                for(int d1 = 1; d1 < N; d1++) {
                    for(int d2 = 1; d2 < N; d2++) {
                        if(isRangeR(i,j,d1,d2)) {
                            visited = new int[N+1][N+1];
                            sum = new int[5];
                            S5(i,j,d1,d2);
                            S1(i,j,d1);
                            S2(i,j,d2);
                            S3(i,j,d1,d2);
                            S4(i,j,d1,d2);

                            for(int k = 1; k < N+1; k++) {
                                for(int l =1; l < N+1; l++) {
                                    if(visited[k][l] == 1) {
                                         sum[0] += map[k][l];
                                    }
                                    if(visited[k][l] == 2) {
                                        sum[1] += map[k][l];
                                    }
                                    if(visited[k][l] == 3) {
                                        sum[2] += map[k][l];
                                    }
                                    if(visited[k][l] == 4) {
                                        sum[3] += map[k][l];
                                    }
                                    if(visited[k][l] == 5 || visited[k][l]== 0) {
                                        sum[4] += map[k][l];
                                    }
                                }
                            }

                            Arrays.sort(sum);
                            list.add(sum[4] - sum[0]);
                        }

                    }
                }
            }
        }

//        System.out.println(list);

        Collections.sort(list);
        System.out.println(list.get(0));



    }


    static boolean isRangeR(int r,int c,int d1,int d2) {
        if (d1 >= 1 && d2 >= 1) {
            if (r + d1 + d2 <= N) {
                if (1 <= c - d1) {
                    if (c + d2 <= N) {
                        return true;
                    }
                }
            }
        }
        return false;

    }



    //1
    static void S1(int r , int c, int d1) {
        int sum = 0;
        for(int i = 1; i < r+d1; i++) {
            for(int j = 1; j <= c; j++) {
//                sum += map[i][j];
                if(visited[i][j] == 5) {
                    break;
                }else {
                    visited[i][j] = 1;
                }
            }
        }

    }
    static void S2(int r , int c, int d2) {
        int sum = 0;
        for(int i = 1; i <= r+d2; i++) {
            for(int j = N; j > c; j--) {
//                sum += map[i][j];
                if(visited[i][j] == 5) {
                    break;
                }else {
                    visited[i][j] = 2;
                }
            }
        }
//        return sum;
    }
    static void S3(int r, int c, int d1, int d2) {
//        int sum = 0;
        for(int i = r+d1; i < N+1; i++) {
            for(int j = 1; j < c-d1+d2; j++) {
//                sum +=map[i][j];
                if(visited[i][j] == 5) {
                    break;
                }else {
                    visited[i][j] = 3;
                }

            }
        }
//        return sum;
    }
    static void S4(int r, int c, int d1, int d2) {
//        int sum = 0;
        for(int i = r+d2+1; i < N+1; i++) {
            for(int j = N; j >= c-d1+d2; j--) {
//                sum += map[i][j];
                if(visited[i][j] == 5) {
                    break;
                }else {
                    visited[i][j] = 4;
                }
            }
        }
//        return sum;
    }
    static void S5(int r, int c , int d1, int d2) {
//        int sum = 0;
//        for(int i = 1 ; i < N+1; i++) {
//            for(int j = 1; j < N+1; j++) {
//                sum += map[i][j];
//            }
//        }
        for (int i = 0; i <= d1; i++) {
            visited[r + i][c - i] = 5;
            visited[r + d2 + i][c + d2 - i] = 5;
        }

        for (int i = 0; i <= d2; i++) {
            visited[r + i][c + i] = 5;
            visited[r + d1 + i][c - d1 + i] = 5;
        }



     }
    //2

    //3

    //4

    //5

}
