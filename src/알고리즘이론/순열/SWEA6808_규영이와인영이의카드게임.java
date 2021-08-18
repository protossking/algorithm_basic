package 알고리즘이론.순열;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA6808_규영이와인영이의카드게임 {

    static int[] gyu = new int[9];
    static int[] in = new int[9];
    static int[] innum = new int[9];
    static boolean[] cardSelect = new boolean[19];
    static boolean[] isSelected = new boolean[19];
    static int win;
    static int lose;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new StringReader(src));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            win = 0;
            lose = 0;
            for (int i = 0; i < gyu.length; i++) {
                gyu[i] = Integer.parseInt(st.nextToken());
                cardSelect[gyu[i]] = true;
            }
            int cnt = 0;
            for (int i = 1; i < 19; i++) {
                if (!cardSelect[i]) {
                    in[cnt++] = i;
                }
            }

            permutation(0);
            System.out.println("#" + tc + " " + win + " " + lose);
        }

    }

    static void permutation(int cnt) {
        if (cnt == 9) {
            int gyuSco = 0;
            int inSco = 0;
            for (int i = 0; i < 9; i++) {
                if (gyu[i] > innum[i]) {
                    gyuSco += gyu[i] + innum[i];
                } else {
                    inSco += gyu[i] + innum[i];
                }
            }
            if (gyuSco > inSco) {
                win++;
            } else if (gyuSco < inSco) {
                lose++;
            }
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (isSelected[i]) continue;
            innum[cnt] = in[i];
            isSelected[i] = true;
            permutation(cnt + 1);
            isSelected[i] = false;

        }
    }


    static String src = "4\n" +
            "1 3 5 7 9 11 13 15 17\n" +
            "18 16 14 12 10 8 6 4 2\n" +
            "13 17 9 5 18 7 11 1 15\n" +
            "1 6 7 9 12 13 15 17 18";
}
