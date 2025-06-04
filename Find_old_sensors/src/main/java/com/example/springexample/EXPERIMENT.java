package com.example.springexample;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;



import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;

public class EXPERIMENT {

    static  SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private static String inputDate = ""; // Укажите вашу дату здесь

    public static void main(String[] args) throws IOException {


/*
      //  Workbook wb = new HSSFWorkbook(fis); //todo конструктор создания книги
        //todo перебор всех ячеек которые существуют:
            String excelFilePath = "your_excel_file.xls"; // Укажите путь к вашему файлу
            try FileInputStream file = new FileInputStream("999.xls");
                 HSSFWorkbook workbook = new HSSFWorkbook(file)) {
                HSSFSheet sheet = workbook.getSheetAt(0);
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (cell.getCellType() == .NUMERIC && DateUtil.isCellDateFormatted(cell)) {
                            Date dateCellValue = cell.getDateCellValue();
                            Date currentDate = new Date();
                            System.out.println("Date in Excel: " + dateCellValue);
                            System.out.println("Current Date: " + currentDate);
                            if (dateCellValue.compareTo(currentDate) == 0) {
                                System.out.println("Date is equal to today");
                            } else if (dateCellValue.compareTo(currentDate) > 0) {
                                System.out.println("Date is in the future");
                            } else {
                                System.out.println("Date is in the past");
                            }
                        }
                    }
                }
            } */
        }
            }





     /*   public static String getCellText(Cell cell){

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
        }*/
