package 알고리즘이론.부분집합;

public class Main {
    static int N;
    static int[] numbers;
    static boolean[] isSelected;
    static int[] input;
    static int total = 0;
    public static void main(String[] args) {
        N = 5;
        numbers = new int[N];
        isSelected = new boolean[N];
        input = new int[]{1,2,3,4,5};

        subset(0);


    }

    private static void subset(int cnt) {
        if(cnt == N) {
            for(int i = 0; i < N; i++) {
                System.out.print(isSelected[i] ? input[i] : "X" + " ");

            }
            System.out.println();
            return;
        }
        isSelected[cnt] = true;
        subset(cnt + 1);
        isSelected[cnt] = false;
        subset(cnt + 1);
    }
}
