package day21_readExcelFile;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {


    @Test
    public void test01() throws IOException {

        String filePath = "src/test/java/day21_readExcelFile/countries.xlsx";
        FileInputStream fis = new FileInputStream(filePath);

        Workbook workbook = WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(1));


        System.out.println(ReusableMethods.printData(3, 3));
        System.out.println(ReusableMethods.printData(13, 2));
        System.out.println(ReusableMethods.printData(77, 1));
        System.out.println(ReusableMethods.printData(144, 0));


    }


}



