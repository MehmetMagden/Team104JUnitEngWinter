package utilities;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ReusableMethods {

    public static void wait (int second){


        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {

        }


    }


    public static String printData(int rowNumber, int cellNumber) {
        String desiredCellStr = "";

        try {
            String filePath = "src/test/java/day21_readExcelFile/countries.xlsx";
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(fis);
            desiredCellStr = workbook.getSheet("Sayfa1").getRow(rowNumber).getCell(cellNumber).toString();


        } catch (IOException e) {
            System.out.println("we have a problem");
        }

        return desiredCellStr;
    }

}
