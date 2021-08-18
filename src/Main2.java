import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] a = new String[3];
        System.out.println(a.length);
        for(int i = 0 ; i < a.length; i++) {
            a[i] = sc.nextLine();
        }

//        for(int i = 0; i < a.length; i++) {
//            a[i] = sc.nextLine();
//            System.out.println(a[i]);
//        }
        System.out.println(Arrays.toString(a));
    }
}
