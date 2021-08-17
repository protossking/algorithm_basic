package 그리디;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 정올_2247_도서관 {

    static int stay;
    static int leave;
    static ArrayList a = new ArrayList();

    static class Library implements Comparable<Library> {

        int start, end;

        public Library(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Library{");
            sb.append("start=").append(start);
            sb.append(", end=").append(end);
            sb.append('}');
            return sb.toString();
        }

        @Override
        public int compareTo(Library l) {
            int value = this.end - l.end;
            if (value != 0) {
                return value;
            }
            return this.start - l.start;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        stay = 0;
        leave = 0;
        Library[] libraries = new Library[N];
        for (int i = 0; i < N; i++) {
            libraries[i] = new Library(sc.nextInt(), sc.nextInt());
        }
        for(Library library : get(libraries)) {
            System.out.println(library);
        }

    }

    static ArrayList<Library> get(Library[] libraries) {
        ArrayList<Library> list = new ArrayList<Library>();
        Arrays.sort(libraries);
        list.add(libraries[0]);
        for(int i = 1, size = libraries.length; i < size; i++) {
            if(list.get(list.size()-1).end <= libraries[i].start) {
                list.add(libraries[i]);


            } else {

            }
        }
        return list;
    }

}
