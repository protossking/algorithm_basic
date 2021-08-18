import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String[] name = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        String first = in.readLine();
        String middle = in.readLine();
        String last = in.readLine();

        for(int i = 0; i < name.length; i++) {
            if(first.equals(name[0])) {
                break;
            }
            if(first.equals(name[i])) {
                sb.append(i);
            }
        }
        for(int i = 0; i < name.length; i++) {
            if(middle.equals(name[i])) {
                sb.append(i);
            }
        }
        for(int i = 1; i <name.length; i++) {
            if(last.equals(name[0])) {
                break;
            }
            if(last.equals(name[i])) {
                if(middle.equals(name[0]) && first.equals(name[0])) {

                    sb = new StringBuilder();
                    sb.append(0);
                    break;
                }
                for(int j = 0; j < i; j++) {
                    sb.append("0");
                }




            }
        }


        System.out.println(sb);

    }


}
