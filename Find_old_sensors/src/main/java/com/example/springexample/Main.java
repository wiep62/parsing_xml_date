package com.example.springexample;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //todo БЛОК выдает разницу между настоящей датой и заплонированной
        // Предположим, сегодняшняя дата
        LocalDate currentDate = LocalDate.now();
        // Пример даты из таблицы (например, 5 мая 2025 года)
        LocalDate dateFromTable = LocalDate.of(2025, 5, 15);
        // Разница в днях между текущей датой и датой из таблицы
        long daysBetween = ChronoUnit.DAYS.between(currentDate, dateFromTable);
        System.out.println(daysBetween);
        /*********************************************************************************/



        }
/*
 while (today.isAfter(birthday.plusYears(1))) {
           System.out.println(birthday.plusYears(1));

       }
*/


    }
