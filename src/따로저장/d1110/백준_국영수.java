package 따로저장.d1110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_국영수 {

    static class Student implements Comparable<Student>{
        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }



        @Override
        public int compareTo(Student o) {
            if(this.kor != o.kor) return o.kor - this.kor;
            if(this.eng != o.eng) return this.eng - o.eng;
            if(this.math != o.math) return o.math - this.math;
            return this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        List<Student> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            list.add(new Student(name, k, e, m));

        }
        Collections.sort(list);
        for(Student s : list) {
            System.out.println(s.name);
        }
    }
}
