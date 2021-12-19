package br.com.exercises.dateapi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ExerciseDates {

    public static void main(String[] args) {
        LocalDate dateNow = LocalDate.now();
        System.out.println("current date : " + dateNow);
        LocalTime timeNow = LocalTime.now();
        System.out.println("current time : " + timeNow);
        System.out.println("in 1 week it will be : " + dateNow.plusWeeks(1));
        System.out.println("in 1 hour it will be : " + timeNow.plusHours(1));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("formatting the current date to the brazilian standard : " + formatter.format(dateNow));
        LocalDate date = LocalDate.of(1972, 8, 10);
        Period period = Period.between(date, dateNow);
        System.out.println("the difference between the date : "
                + dateNow
                + " and the date : "
                + date
                + " and from : "
                + period.getYears()
                + " Years " + period.getMonths()
                + " Months "
                + period.getDays()
                + " Days"
        );
    }

}
