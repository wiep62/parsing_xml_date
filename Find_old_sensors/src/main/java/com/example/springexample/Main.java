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
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("MM:yyyy");

    public static void main(String[] args) throws InterruptedException, IOException {
        final int NUM_OF_COLUMNS = 7;
        final int NUM_OF_ROWS = 150;
        final double SERIAL_NUMBER  = 4031604;

        //todo Блок прохождения по датам и формирование новых строчек в новом листе файла с названием текущей даты
        //todo читаем файл: не можем вычитывать все данные как Str, используем универсальную функцию

        FileInputStream fis = new FileInputStream("111.xls");
        FileOutputStream fos  = new FileOutputStream("OUTput.xls");

        Workbook wb = new HSSFWorkbook(fis); //todo конструктор создания книги
        Workbook wb1 = new XSSFWorkbook();
     //   XSSFWorkbook wb = new XSSFWorkbook();
      //  XSSFWorkbook wb1 = new XSSFWorkbook();


        Sheet sheet = wb.getSheetAt(1); //считываем данные со страницы
        Sheet sheet0  = wb1.createSheet("TEST_PAGES"); //создаем переменную вкладка

      //  XSSFSheet sheet = wb.getSheetAt(1);
      //  XSSFSheet sheet0 = wb1.createSheet("TEST");



       // System.out.println(wb.getSheetAt(0).getRow(4).getCell(2));
int i = 1;
int z = 0;

        Row row;
        Cell cell;
        for (int rowIndex = 0; rowIndex < NUM_OF_ROWS; rowIndex++) {
           row = sheet.getRow((short) rowIndex);

        //todo перебор всех ячеек которые существуют:
       // for (Row row : wb.getSheetAt(1)) {
            System.out.println("rowIndex = " + z++);

            Row row1 = sheet0.createRow(rowIndex);

            for (int j = 0; j <= NUM_OF_COLUMNS; j++) {
                if (getCellText(row.getCell(j)).isEmpty()){ //todo проверка ячейка на null
                    row.getCell(j).setCellValue((short) 0);
                }

                System.out.println("j = " + j);
//todo проверяем датчики меньше серийного номера:
            if (Double.parseDouble(getCellText(row.getCell(3)) ) <=  SERIAL_NUMBER) {
                Cell cellNew = row1.createCell(j);

                    System.out.print( getCellText(row.getCell(j)) + " "); //getCellText(cell) - выдает значение ячейки
                //todo зарлдняем новый лист:

                switch (j){
                    case 0:
                        cellNew.setCellValue(getCellText(row.getCell(j)));
                        System.out.print("\n" +  "ZAPISALI : " + getCellText(row.getCell(j)) + " "); //getCellText(cell) - выдает значение ячейки
                        break;
                    case 1:
                        cellNew.setCellValue(getCellText(row.getCell(j)));
                        System.out.print("\n" +  "ZAPISALI : " + getCellText(row.getCell(j)) + " "); //getCellText(cell) - выдает значение ячейки
                        break;
                    case 2:
                        cellNew.setCellValue(getCellText(row.getCell(j)));
                        System.out.print("\n" +  "ZAPISALI : " + getCellText(row.getCell(j)) + " "); //getCellText(cell) - выдает значение ячейки

                        break;
                    case 3:
                        cellNew.setCellValue(getCellText(row.getCell(j)));
                        System.out.print("\n" +  "ZAPISALI : " + getCellText(row.getCell(j)) + " "); //getCellText(cell) - выдает значение ячейки

                        break;
                    case 4:
                        cellNew.setCellValue(getCellText(row.getCell(j)));
                        System.out.print("\n" +  "ZAPISALI : " + getCellText(row.getCell(j)) + " "); //getCellText(cell) - выдает значение ячейки

                        break;
                    case 5:
                        cellNew.setCellValue(getCellText(row.getCell(j)));
                        System.out.print("\n" +  "ZAPISALI : " + getCellText(row.getCell(j)) + " "); //getCellText(cell) - выдает значение ячейки

                        break;
                    case 6:
                        cellNew.setCellValue(getCellText(row.getCell(j)));
                        System.out.print("\n" +  "ZAPISALI : " + getCellText(row.getCell(j)) + " "); //getCellText(cell) - выдает значение ячейки

                        break;
                        case 7:
                            cellNew.setCellValue(getCellText(row.getCell(j)));
                            System.out.print("\n" + "ZAPISALI : " + getCellText(row.getCell(j)) + " "); //getCellText(cell) - выдает значение ячейки

                            System.out.println("\n");
                            break;
                    }


            }

            }



        }
//работа с листами:


        wb1.write(fos); //пишем в поток
        fos.close();
        wb1.close();
        fis.close();


        /*
         FileInputStream fis = new FileInputStream("111.xls");
         Workbook wb = new XSSFWorkbook(fis); //todo конструктор создания книги

     System.out.println(wb.getSheetAt(1).getRow(0).getCell(0));
        System.out.println(wb.getSheetAt(1).getRow(0).getCell(1));
        System.out.println(wb.getSheetAt(1).getRow(0).getCell(4));
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