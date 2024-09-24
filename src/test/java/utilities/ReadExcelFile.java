package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadExcelFile {

    public static FileInputStream fis;
    public static XSSFWorkbook workbook;
    public static XSSFSheet excelSheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static String getCellValue(String fileName, String sheetName, int row, int column) {
        try {
            fis = new FileInputStream(fileName);
            workbook = new XSSFWorkbook(fis);
            excelSheet = workbook.getSheet(sheetName);
            cell = excelSheet.getRow(row).getCell(column);

            workbook.close();

            return cell.getStringCellValue();
        }
        catch(Exception exception) {
            return " ";
        }
    }

    public static int getRowCount(String fileName, String sheetName) {
        try {
            fis = new FileInputStream(fileName);
            workbook = new XSSFWorkbook(fis);
            excelSheet = workbook.getSheet(sheetName);

            int row = excelSheet.getLastRowNum() + 1;

            workbook.close();

            return row;
        }
        catch(Exception exception) {
            return 0;
        }
    }

    public static int getColumnCount(String fileName, String sheetName) {
        try {
            fis = new FileInputStream(fileName);
            workbook = new XSSFWorkbook(fis);
            excelSheet = workbook.getSheet(sheetName);

            int column = excelSheet.getRow(0).getLastCellNum();

            workbook.close();

            return column;
        }
        catch(Exception exception) {
            return 0;
        }
    }


}
