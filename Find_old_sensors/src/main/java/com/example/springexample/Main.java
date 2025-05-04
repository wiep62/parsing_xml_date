package com.example.springexample;

import com.sun.jdi.IntegerType;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Main {
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd");

    public static void main(String[] args) throws InterruptedException, IOException {
        final int NUM_OF_COLUMNS = 8;

        //todo Блок прохождения по датам и формирование новых строчек в новом листе файла с названием текущей даты
        //todo читаем файл: не можем вычитывать все данные как Str, используем универсальную функцию

        FileInputStream fis = new FileInputStream("111.xls");
        Workbook wb = new HSSFWorkbook(fis); //todo конструктор создания книги
        System.out.println(wb.getSheetAt(0).getRow(4).getCell(2));
int i = 1;

        //todo перебор всех ячеек которые существуют:
        for (Row row : wb.getSheetAt(1)) {
            for (Cell cell : row) {
        System.out.print( getCellText(cell) + " "); //getCellText(cell) - выдает значение ячейки
if(getCellText(cell).isEmpty() && i++ % NUM_OF_COLUMNS == 0){   //разделяем строки
    System.out.println("\n");
}
    }
        }

        fis.close();


        /*
         FileInputStream fis = new FileInputStream("111.xls");
         Workbook wb = new XSSFWorkbook(fis); //todo конструктор создания книги

     System.out.println(wb.getSheetAt(1).getRow(0).getCell(0));
        System.out.println(wb.getSheetAt(1).getRow(0).getCell(1));
        System.out.println(wb.getSheetAt(1).getRow(0).getCell(4));
*/

/*
        XSSFSheet sheet = (XSSFSheet) wb.createSheet("linechart");
        final int NUM_OF_ROWS = 3;
        final int NUM_OF_COLUMNS = 10;
        // Create a row and put some cells in it. Rows are 0 based.
        Row row;
        Cell cell;
        for (int rowIndex = 0; rowIndex < NUM_OF_ROWS; rowIndex++) {
            row = sheet.createRow((short) rowIndex);
            for (int colIndex = 0; colIndex < NUM_OF_COLUMNS; colIndex++) {
                cell = row.createCell((short) colIndex);
                cell.setCellValue(colIndex * (rowIndex + 1.0));
            }
        }
*/

    }


    //todo перебор всех ячеек которые существуют:


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
    /*    ArrayList <String> dateString = new ArrayList<>();
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
        }*/



/*
 while (today.isAfter(birthday.plusYears(1))) {
           System.out.println(birthday.plusYears(1));

       }
*/
    public static String getCellText(Cell cell) {
        String result = "";
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                result = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    result = dateFormat.format(cell.getDateCellValue());
                } else {
                    result = Double.toString(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                result = Boolean.toString(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                result = (cell.getCellFormula().toString());
                break;
            default:
        }
        return result;
    }

}