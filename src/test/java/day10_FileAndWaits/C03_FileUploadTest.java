package day10_FileAndWaits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_FileUploadTest extends TestBase {

    @Test
    public void test01(){


        //Create a class under the Tests package: C05_ UploadFile
        //Let's go to https://the-internet.herokuapp.com/upload
        //Let's press the chooseFile button
        //Select the file you want to upload .
        //Hit the upload button .
        //“File Uploaded!” Let's test that the text is displayed .


        //Let's go to https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        //Let's press the chooseFile button
        //Select the file you want to upload .
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
        String filePath ="C:\\Users\\Maden\\Desktop\\Yeni Microsoft Word Belgesi.docx"; // not dynamic
        // we have sent the filepath directly to choose the file from our computer

        chooseFileButton.sendKeys(filePath);

        //Hit the upload button .
        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” Let's test that the text is displayed .
        WebElement textElement = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(textElement.isDisplayed());



        ReusableMethods.wait(5);




    }
}
