package d1216;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2016, 1, 1);

        DayOfWeek d = date.getDayOfWeek();

        int day = d.getValue();

        System.out.println(day);



        if(day == 1) {
            System.out.println("MON");
        }
        else if(day == 2) {
            System.out.println("TUE");
        }
        else if(day == 3) {
            System.out.println("WEB");
        }
        else if(day == 4) {
            System.out.println("THU");
        }
        else if(day == 5) {
            System.out.println("FRI");
        }
        else if(day == 6) {
            System.out.println("SAT");
        }
        else if(day == 7) {
            System.out.println("SUN");
        }

    }
}
