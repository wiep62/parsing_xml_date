package com.example.springexample;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormat extends CellAndRow{
    private static String inputDate = ""; // Укажите вашу дату здесь

    public DateFormat() throws FileNotFoundException {
        super();
       // this.inputDate = inputDate;
    }

    public static String getInputDateFormat(String inputDate) {
       // this.inputDate = inputDate;

        if (inputDate.matches("^\\d{2}\\.\\d{4}$")) {
            // Если дней нет, добавляем "01" к строке даты
            inputDate = "01." + inputDate;
        }
        // Определяем формат даты
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = inputFormat.parse(inputDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        // Форматируем дату в нужном формате
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd.MM.yyyy");
        return outputFormat.format(date);

    }
    // Пример даты в формате "MM.yyyy"

    public static void getHowManyMonths(int cellDate, int row, Sheet sheet){
      //  System.out.println("Разница между датами в месяцах: " );

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate today = LocalDate.now(); //сегодняшняя дата
        String textToday = today.format(formatter); //сегодняшняя дата в текстовом представлении

        // Ввод второй даты

      for(int i = 1; i <=row; i++){
          if (sheet.getRow(i).getCell(cellDate) != null) {
              String secondDateInput = getCellText(sheet.getRow(i).getCell(cellDate));
              System.out.println(secondDateInput);
              //todo преобразование даты:

              if (secondDateInput.matches("^\\d{2}\\.\\d{4}$")) {
                  // Если дней нет, добавляем "01" к строке даты
                  secondDateInput = "01." + secondDateInput;
                  System.out.println("Добавили 01: ");
              }

             // System.out.println(secondDateInput);
             // System.out.println("Today : " + textToday);
           //   System.out.println("secondDateInput : " + secondDateInput);

              LocalDate parseToday = LocalDate.parse(textToday, formatter);  //преобразуем текст в дату
              LocalDate parseSecondDateInput = LocalDate.parse(secondDateInput, formatter);  //преобразуем текст в дату

              // Вычисление разницы между датами
              Period period = Period.between(parseToday, parseSecondDateInput);
            //  System.out.println("parseToday : " + parseToday + "\n" + "parseSecondDateInput : " + parseSecondDateInput);
              System.out.println(period);
              // Получение разницы в месяцах
              int monthsDifference = period.getYears() * 12 + period.getMonths();

              //   System.out.println("Разница между датами в месяцах: " + monthsDifference);

            if (monthsDifference <=10){
                System.out.println("До оканчания поверки осталось: " + monthsDifference + " месяцев");
            }
              // return monthsDifference;


          } else {
              System.out.println("значение отсутствует");
          }
      }







    /*    // Определяем формат даты
      SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = inputFormat.parse(secondDateInput);

            System.out.println("date = inputFormat.parse(inputDate);01: ");

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        // Форматируем дату в нужном формате
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd.MM.yyyy");
        outputFormat.format(date);
        System.out.println("outputFormat: " + outputFormat + "\n" + "date : " + date);
*/


        // LocalDate secondDate = LocalDate.parse(outputFormat.format(date), formatter);

       // LocalDate parseToday = LocalDate.parse(textToday, formatter);


    }
}




