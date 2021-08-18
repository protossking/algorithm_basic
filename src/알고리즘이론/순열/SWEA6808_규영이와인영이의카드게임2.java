package 알고리즘이론.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA6808_규영이와인영이의카드게임2 {


    static int[] gyu;
    static int[] iy;
    static int[] itemp;
    static boolean[] cardSelect;
    static int win;
    static int lose;
    static boolean[] isSelected;



    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(src));
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb;
        int T = Integer.parseInt(in.readLine());



        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            win = 0;
            lose = 0;
            gyu = new int[9];
            iy = new int[9];
            cardSelect = new boolean[19];
            itemp = new int[9];
            isSelected = new boolean[19];
            sb = new StringBuilder();

            for(int i = 0; i < 9; i++) {
                gyu[i] = Integer.parseInt(st.nextToken());
                cardSelect[gyu[i]] = true;
            }
            int cnt = 0;
            for(int i = 1; i < 19; i++) {
                if(!cardSelect[i]) {
                    iy[cnt++] = i;
                }
            }



            perm(0);
            sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose);
            System.out.println(sb);

        }



    }
    static void perm(int cnt) {
        if(cnt == 9) {
            int gS =0 ;
            int iS = 0;
            for(int i = 0; i < 9; i ++) {
                if(gyu[i] > itemp[i]) {
                    gS += gyu[i] + itemp[i];
                }
                if(gyu[i] < itemp[i]) {
                    iS += gyu[i] + itemp[i];
                }
            }
            if(gS > iS){
                win ++;
            }
            else if (gS < iS) {
                lose++;
            }
            return;
        }
        for(int i = 0; i < 9; i++) {
            if(isSelected[i]) continue;
            itemp[cnt] = iy[i];
            isSelected[i] = true;
            perm(cnt + 1);
            isSelected[i]= false;

        }
    }




    static String src = "4\n" +
            "1 3 5 7 9 11 13 15 17\n" +
            "18 16 14 12 10 8 6 4 2\n" +
            "13 17 9 5 18 7 11 1 15\n" +
            "1 6 7 9 12 13 15 17 18";
}
