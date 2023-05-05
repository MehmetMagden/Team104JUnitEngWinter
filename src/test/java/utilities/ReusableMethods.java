package utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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


    public static void takeFullScreenShot(WebDriver driver) {

        // 1) we need to create a TakeScreenshot object
        TakesScreenshot tss = (TakesScreenshot) driver;
        // 2) create the file to save ss
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String date = ldt.format(dtf);
        String filePath ="target/ss/ScreenShot"+date+".jpeg";
        File fullPageScreenShot = new File(filePath);

        // 3) let's take the ss and save it to the file
        File tempFile = tss.getScreenshotAs(OutputType.FILE);

        // 4) we need a temp file to save our file (reason is unknown)
        try {
            FileUtils.copyFile(tempFile,fullPageScreenShot);
        } catch (IOException e) {
            System.out.println("could not copy");
        }
    }

    public static void takeElementScreenShot(WebElement webElement) {



        // take SS of results

        // 1) create a filepath for the SS
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String date = ldt.format(dtf);

        String filePath = "target/SS_Element/SS_OfDesiredElement"+date+".jpeg";

        // 2) create a  file
        File elementSS = new File(filePath);

        // 3) create a temp file
        File temp = webElement.getScreenshotAs(OutputType.FILE);

        // 4) copy this file to the original
        try {
            FileUtils.copyFile(temp,elementSS);
        } catch (IOException e) {
            System.out.println("could not copy the file");
        }
    }
}
