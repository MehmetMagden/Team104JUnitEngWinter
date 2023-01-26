package day22_writeExcelFile;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcelFile {


    @Test
    public void test01() throws IOException {

        // just like reading process we will be using workbook to work on the file
        // let's create a copy of Excel file

        String filePath = "src/test/java/day21_readExcelFile/countries.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook  workbook = WorkbookFactory.create(fis);

        // let's add Numbers title to row 0 cell 4
        workbook.getSheet("Sayfa1").getRow(0).createCell(5).setCellValue("Numbers");

        // add 1500000 number to 3. row under Numbers title
        workbook.getSheet("Sayfa1").getRow(2).createCell(5).setCellValue("1500000");

        // add 3000000 to 7. row under Numbers title
        workbook.getSheet("Sayfa1").getRow(6).createCell(5).setCellValue("3000000");

        // so far we only worked on workbook copy of Excel file
        // to save these to our Excel file, we need to save
        // to save we will use "FileOutputStream" class

        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);

        workbook.close();
        fis.close();
        fos.close();

    }
}
