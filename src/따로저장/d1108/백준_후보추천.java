package 따로저장.d1108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_후보추천 {

    static class Student implements Comparable<Student> {
        int index;
        int man;
        int cnt;

        public Student(int index, int man, int cnt) {
            this.index = index;
            this.man = man;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Student o) {
            if(this.cnt == o.cnt) {
                return this.index - o.index;
            }
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        List<Student> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < M; i++) {
            int input = Integer.parseInt(st.nextToken());
            boolean isSaved = false;
            if(list.size() < N) {
                for(Student student : list) {
                    if(student.man == input) {
                        student.cnt ++;
                        isSaved = true;
                        break;
                    }
                }
                if(!isSaved) {
                    list.add(new Student(i, input, 1));
                }
            }


            else {
                Collections.sort(list);
                for(Student s : list) {
                    if(s.man == input) {
                        s.cnt ++;
                        isSaved = true;
                        break;
                    }
                }
                if(!isSaved) {
                    list.remove(0);
                    list.add(new Student(i, input, 1));
                }

            }
        }
        for(Student s : list) {
            ans.add(s.man);
        }
//        System.out.println(ans);
        Collections.sort(ans);
        for(Integer n : ans) {
            System.out.print(n + " ");
        }







    }



}
