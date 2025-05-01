package com.example.springexample;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //todo БЛОК выдает разницу между настоящей датой и заплонированной
        // Предположим, сегодняшняя дата
       /* LocalDate currentDate = LocalDate.now();
        // Пример даты из таблицы (например, 5 мая 2025 года)
        LocalDate dateFromTable = LocalDate.of(2025, 5, 15);
        // Разница в днях между текущей датой и датой из таблицы
        long daysBetween = ChronoUnit.DAYS.between(currentDate, dateFromTable);
        System.out.println(daysBetween);*/
        /*********************************************************************************/
//todo Блок парсинга текста в дату:
       // String dateString = "2025-05-01"; // Текстовое значение даты
        ArrayList <String> dateString = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd"); // Формат даты
        dateString.add("2025.05.01");
        dateString.add("2024.02.01");
        dateString.add("2022.04.23");
        dateString.add("2325.02.19");
        try {
         for (int i = 0; i < dateString.size(); i++) {
             LocalDate date = LocalDate.parse(dateString.get(i), formatter); // Парсинг строки в LocalDate
             System.out.println("Parsed LocalDate: " + date);
         }
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка при парсинге даты: " + e.getMessage());
        }


        }
/*
 while (today.isAfter(birthday.plusYears(1))) {
           System.out.println(birthday.plusYears(1));

       }
*/


    }
