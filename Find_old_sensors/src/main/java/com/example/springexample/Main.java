package com.example.springexample;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Date date1 = new Date();

        Thread.sleep(2000);//приостановим работу программы на 2 секунды
        Date date2 = new Date();
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(2025,12,31);

       // System.out.println(date2.before(date1));
        System.out.println(today.isAfter.birthday);




    }
    public static void collectBirthdays(int year, int month, int day){
        LocalDate birthday = LocalDate.of(year,month,day);
        LocalDate today = LocalDate.now();
        for (int i = 0; i <30; i++) {

            System.out.println(birthday.plusYears(1));
        }
/*
 while (today.isAfter(birthday.plusYears(1))) {
           System.out.println(birthday.plusYears(1));

       }
*/


    }
}