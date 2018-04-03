import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class main {

    public static void main(String[] args) throws Exception {
        File myFile = new File("C:\\Users\\Jojo\\Desktop\\Skola\\PSCobci.xlsx");

        FileInputStream fis = new FileInputStream(myFile);

        // Finds the workbook instance for XLSX file
        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);

        // Return first sheet from the XLSX workbook
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);

        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = mySheet.iterator();

        // Traversing over each row of XLSX file
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        //System.out.print(cell.getStringCellValue() + "\t");
                        break;
                    default:
                }
            }

            String Obec = row.getCell(0).getStringCellValue();
            String Okres = row.getCell(1).getStringCellValue();
            String Psc = row.getCell(2).getStringCellValue();
            System.out.println(Obec + Okres + Psc);
            Psc ex = new Psc();

            ex.InsertRowInDB(Obec, Okres, Psc);
            // System.out.println("");
        }
    }
}




