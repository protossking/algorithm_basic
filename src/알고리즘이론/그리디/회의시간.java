package 알고리즘이론.그리디;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 회의시간 {

    static class Meeting implements Comparable<Meeting> {
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            int value = this.end - o.end;
            if(value != 0) {
                return value;
            }
            return this.start - o.start;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Meeting{");
            sb.append("start=").append(start);
            sb.append(", end=").append(end);
            sb.append('}');
            return sb.toString();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Meeting[] meetings = new Meeting[N];
        for(int i = 0; i < N; i++) {
            meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
        }
        for(Meeting meeting: getSchedule(meetings)) {
            System.out.println(meeting);
        }
    }
    static ArrayList<Meeting> getSchedule(Meeting[] meetings) {
        ArrayList<Meeting> list = new ArrayList<>();
        Arrays.sort(meetings);
        list.add(meetings[0]);
        for(int i = 1, size = meetings.length; i <size; i++) {
            if(list.get(list.size()-1).end <= meetings[i].start) {
                list.add(meetings[i]);
            }
        }
        return list;
    }
}
