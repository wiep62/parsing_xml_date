package com.example.springexample;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import static com.example.springexample.CellAndRow.getCellText;


public class CellAndRow {
    private static SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd.MM.yyyy");

    private  Row row;
    private Cell cell;

/*    public CellAndRow(Row row, Cell cell) {
        this.row = row;
        this.cell = cell;
    }*/
    public CellAndRow() {

    }

    //todo Блок прохождения по датам и формирование новых строчек в новом листе файла с названием текущей даты
    //todo читаем файл: не можем вычитывать все данные как Str, используем универсальную функцию


/*
public void workWithFile(int NUM_OF_ROWS, int NUM_OF_COLUMNS, String inputFile, String outputFile, String nameGetSheet, String nameCreateSheet) throws IOException {

    FileInputStream fis = new FileInputStream(inputFile);
    FileOutputStream fos  = new FileOutputStream(outputFile);
      Workbook wb = new HSSFWorkbook(fis); //todo конструктор создания книги
    Workbook wb1 = new HSSFWorkbook();
    Sheet sheet = wb.getSheet(nameGetSheet); //считываем данные со страницы
    Sheet sheet0  = wb1.createSheet(nameCreateSheet); //создаем переменную вкладка


    for (int rowIndex = 1; rowIndex < NUM_OF_ROWS; rowIndex++) {
        row = sheet.getRow((short) rowIndex);

        //todo перебор всех ячеек которые существуют:
        for (Row row : wb.getSheet(nameGetSheet)) {

          //  Row row1 = sheet0.createRow(rowIndex);

            for (int j = 0; j <= NUM_OF_COLUMNS; j++) {
                if (getCellText(row.getCell(j)).isEmpty()){ //todo проверка ячейка на null
                    row.getCell(j).setCellValue((short) 0);
                }
            }}}
}
*/
  //todo метод форматирует столбец с датой в необходимы вид, в пустые ячейки (null) добавляет 0
    public static void formatCell(int NUM_OF_ROWS, int NUM_OF_COLUMNS, Sheet sheet, Sheet sheet0) {
      //  if (sheet.getRow(NUM_OF_ROWS).getCell(NUM_OF_COLUMNS) != null) {
//String formatCell = "";
            for (int rowIndex = 1; rowIndex <= NUM_OF_ROWS; rowIndex++) {
                System.out.println("rowIndex = " + rowIndex);

                  for (int j = 0; j <= NUM_OF_COLUMNS; j++) {
                    System.out.println("rowIndex = " + rowIndex + ", columnIndex = " + j);
                    System.out.println(getCellText(sheet.getRow(rowIndex).getCell(j)));
                    if (getCellText(sheet.getRow(rowIndex).getCell(j)).isEmpty()) { //todo проверка ячейка на null
                    sheet.createRow(rowIndex).createCell(j).setCellValue((short) 0);
                       // System.out.println("vstavka");
                       // sheet0.createRow(i).createCell(i).setCellValue((short) 0);
                       System.out.println("vstavka");
                    } else {                       System.out.println("OK-OK-OK");
                    }
                   //   formatCell =   sheet0.getRow(rowIndex).getCell(j).setCellValue("vstavka");

                  }

            }

    }



        //todo создаем новую строку таблицы:
   public void newRow(int j, int a,Sheet sheet){

       Cell cellNew = sheet.createRow(a).createCell(j);

       switch (j){
           case 0:

               cellNew.setCellValue(getCellText(sheet.getRow(a).getCell(j)));
               break;
           case 1:
               cellNew.setCellValue(getCellText(sheet.getRow(a).getCell(j)));
               break;
           case 2:
               cellNew.setCellValue(getCellText(sheet.getRow(a).getCell(j)));
               break;
           case 3:
               cellNew.setCellValue(getCellText(sheet.getRow(a).getCell(j)));
               break;
           case 4:
               cellNew.setCellValue(getCellText(sheet.getRow(a).getCell(j)));
               break;
           case 5:
               cellNew.setCellValue(getCellText(sheet.getRow(a).getCell(j)));
               break;
           case 6:
               cellNew.setCellValue(getCellText(sheet.getRow(a).getCell(j)));
               break;
           case 7:
               cellNew.setCellValue(getCellText(sheet.getRow(a).getCell(j)));
               System.out.println("\n");
               break;
       }
   }

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



