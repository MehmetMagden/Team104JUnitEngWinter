package day21_readExcelFile;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ReadExcel {

    // We will use countries.xlsx  file to read
    // first we need to reach the file

@Test
    public void test01() throws IOException {

    String filePath = "src/test/java/day21_readExcelFile/countries.xlsx";
    FileInputStream fis = new FileInputStream(filePath);
    Workbook workbook = WorkbookFactory.create(fis);

    // let's reach row 1 and cell 2 and print it
    System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));

    // let's reach row1 cell1 and assign it to a variable
    String desiredCellStr = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
    System.out.println(desiredCellStr);

    // let's reach row 2 cell 4 and test it
    String actualCellStr = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
    String expectedCellStr = "Kabil";
    Assert.assertEquals(expectedCellStr,actualCellStr);

    // Try to find how many rows Excel file has
    System.out.println("Row number : "+(workbook.getSheet("Sayfa1").getLastRowNum()+1));

    // find how many rows are used  in second sheet
    System.out.println("Physically used rows of second sheet : "+workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());
    System.out.println("Row number of second sheet : "+(workbook.getSheet("Sayfa2").getLastRowNum()+1));

    // let's create a map to store excel file

    Map<String,String> countryMap = new TreeMap<>();
    int lastRowIndex = workbook.getSheet("Sayfa1").getLastRowNum();

    String key="";
    String value="";

    for (int i = 0; i <=lastRowIndex ; i++) {

        key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

        value= workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() +", "+
                workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+", "+
                workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

    countryMap.put(key,value);
    }
    System.out.println(countryMap);
}



}
