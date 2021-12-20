package 따로저장.d1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 톱니바퀴 {



    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[][] t = new int[5][9];
        String[] str = new String[8];
        for(int i = 1; i <= 4; i++) {
            String[] split = in.readLine().split("");
            for(int j = 1; j <= 8; j++) {
                t[i][j] = Integer.parseInt(split[j-1]);
            }

        }


        int k = Integer.parseInt(in.readLine());

        StringTokenizer st;
        while (k-- > 0) {
            st = new StringTokenizer(in.readLine());
            int w = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            boolean[] check = new boolean[4];

            for(int i = 1; i < 4; i++) {
                if(t[i][3] == t[i+1][7]) {
                    check[i] = true;
                }
            }

            if(w == 1) {
                rotation(d, t, w);
                if(!check[w]) {
                    d = change(d);
                    rotation(d, t, w+1);

                    if(!check[2]) {
                        d = change(d);
                        rotation(d, t, 3);

                        if(!check[3]) {
                            d = change(d);
                            rotation(d, t, 4);
                        }
                    }
                }
            }

            else if( w == 2) {
                rotation(d, t, w);
                if(!check[w-1] || !check[w]) {
                    if(!check[w-1]) {
                        d = change(d);
                        rotation(d, t, w-1);
                        d = change(d);
                    }
                    if(!check[w]) {
                        d = change(d);
                        rotation(d, t, w+1);

                        if(!check[2]) {
                            d = change(d);
                            rotation(d, t, 4);
                        }
                    }
                }
            }
            else if(w == 3){
                rotation(d, t, w);
                if(!check[w] || !check[w-1]) {
                    if(!check[w]) {
                        d = change(d);
                        rotation(d, t, w+1);
                        d = change(d);
                    }
                    if(!check[w-1]) {
                        d = change(d);
                        rotation(d, t, w-1);

                        if(!check[0]) {
                            d = change(d);
                            rotation(d, t, 1);
                        }
                    }
                }
            }
            else if(w == 4) {
                rotation(d, t, w);

                if(!check[w-1]) {
                    d = change(d);
                    rotation(d, t, 3);

                    if(!check[1]) {
                        d = change(d);
                        rotation(d, t, 2);
                        if(!check[0]) {
                            d =  change(d);
                            rotation(d, t, 1);
                        }
                    }
                }
            }


        }
        int sum = 0;
        if(t[1][1] == 1) {
            sum += 1;
        }
        if(t[2][1] == 1) {
            sum += 2;
        }
        if(t[3][1] == 1) {
            sum += 4;
        }
        if(t[4][1] == 1) {
            sum += 8;
        }
        System.out.println(sum);
    }
    static int change (int d) {
        if( d == 1) {
            d = -1;
        }
        else if (d == -1) {
            d = 1;
        }
        return d;
    }

    static void rotation(int d, int[][] t, int w) {
        if(d == 1) {
            int temp = t[w][8];
            for(int i = 8; i >= 2; i--) {
                t[w][i] = t[w][i-1];
            }
            t[w][1] = temp;
        }
        else {
            int temp = t[w][1];
            for(int i = 2; i <= 8; i++) {
                t[w][i-1] = t[w][i];
            }
            t[w][8] = temp;
        }
    }
}
