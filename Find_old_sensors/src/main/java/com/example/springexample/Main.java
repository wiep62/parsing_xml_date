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
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import static com.example.springexample.CellAndRow.formatCell;
import static com.example.springexample.CellAndRow.getCellText;
import static com.example.springexample.DateFormat.getHowManyMonths;

public class Main {
   // static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
   private static SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd.MM.yyyy");

    public static void main(String[] args) throws InterruptedException, IOException {
        CellAndRow cellAndRow = new CellAndRow();

     String inputFile = "999.xls";
String outputFile = "OUTput111133.xls";
int NUM_OF_ROWS = 70;
int NUM_OF_COLUMNS = 7;
String nameGetSheet = "11";
String nameCreateSheet = "В поверку";

        FileInputStream fis = new FileInputStream(inputFile);
        Workbook wb = new HSSFWorkbook(fis); //todo конструктор создания книги
        Workbook wb1 = new HSSFWorkbook();
        Sheet sheet = wb.getSheet(nameGetSheet); //считываем данные со страницы
        Sheet sheet0  = wb1.createSheet(nameCreateSheet); //создаем переменную вкладка
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate today = LocalDate.now(); //сегодняшняя дата
        String textToday = today.format(formatter); //сегодняшняя дата в текстовом представлении

        // Ввод второй даты

        for(int i = 1; i <=NUM_OF_ROWS; i++){
            if (sheet.getRow(i).getCell(5) != null) {
                String secondDateInput = getCellText(sheet.getRow(i).getCell(5));
              //  System.out.println(secondDateInput);
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
                ///System.out.println(period);
                // Получение разницы в месяцах
                int monthsDifference = period.getYears() * 12 + period.getMonths();

                //   System.out.println("Разница между датами в месяцах: " + monthsDifference);

                if (monthsDifference <=3){
                    System.out.println("До оканчания поверки осталось: " + monthsDifference + " месяцев");

                    Row row = sheet0.createRow(i);

                    for (int j = 0; j <= NUM_OF_COLUMNS; j++) {

    //Cell cell = row.createCell(j);
Cell cell = row.createCell(j);
    switch (j) {
        case 0:
            cell.setCellValue(getCellText(sheet.getRow(i).getCell(j)));

            break;
        case 1:
            cell.setCellValue(getCellText(sheet.getRow(i).getCell(j)));

            break;
        case 2:
            cell.setCellValue(getCellText(sheet.getRow(i).getCell(j)));


            break;
        case 3:
            cell.setCellValue(getCellText(sheet.getRow(i).getCell(j)));


            break;
        case 4:
            cell.setCellValue(getCellText(sheet.getRow(i).getCell(j)));

            break;
        case 5:
            cell.setCellValue(getCellText(sheet.getRow(i).getCell(j)));

            break;
        case 6:
            cell.setCellValue(getCellText(sheet.getRow(i).getCell(j)));

            break;
        case 7:
            cell.setCellValue(getCellText(sheet.getRow(i).getCell(j)));

            break;

    }


}
                }
                // return monthsDifference;


            } else {
                System.out.println("значение отсутствует");
            }


            FileOutputStream fos  = new FileOutputStream(outputFile);

         wb1.write(fos); //пишем в поток
        fos.close();
       wb1.close();

          fis.close();

    }}
    public static String getCellText(Cell cell) {
        String result = "";
        switch (cell.getCellType()) {

            case Cell.CELL_TYPE_STRING:
                result = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    result = dateFormat1.format(cell.getDateCellValue());
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


















        /*        System.out.println(wb.getSheetAt(1).getRow(3).getCell(0));
        System.out.println(wb.getSheetAt(1).getRow(3).getCell(1));

        //HashMap numbersAndNames = new HashMap();

}
}

//formatCell(NUM_OF_ROWS, NUM_OF_COLUMNS, sheet, sheet0);

       /* Row row = sheet.createRow(0);

        Cell cell0 = row.createCell(0);
        cell0.setCellValue(2);



    //todo БЛОК выдает разницу между настоящей датой и заплонированной
    // Предположим, сегодняшняя дата
       /* LocalDate currentDate = LocalDate.now();
        // Пример даты из таблицы (например, 5 мая 2025 года)
        LocalDate dateFromTable = LocalDate.of(2025, 5, 15);
        // Разница в днях между текущей датой и датой из таблицы
        long daysBetween = ChronoUnit.DAYS.between(currentDate, dateFromTable);
        System.out.println(daysBetween);*/

