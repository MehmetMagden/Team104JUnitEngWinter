package day21_readExcelFile;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        // let's create a file path
        String filePath = "src/test/java/day21_readExcelFile/countries.xlsx";

        FileInputStream fis = new FileInputStream(filePath);

        Workbook workbook = WorkbookFactory.create(fis);

        // to reach a sheet
        Sheet sheet = workbook.getSheet("Sayfa1");

        // to reach a row
        Row row = sheet.getRow(5);

        // to reach the cell
        Cell cell = row.getCell(2);

        System.out.println(cell);




    }

}
