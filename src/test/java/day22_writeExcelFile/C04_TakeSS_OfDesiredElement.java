package day22_writeExcelFile;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_TakeSS_OfDesiredElement extends TestBase {


    @Test
    public void test01() {

        // go to the amazon webpage
        driver.get("https://www.amazon.com");

        // search for nutella
        WebElement amazonSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
        amazonSearchBox.sendKeys("nutella"+ Keys.ENTER);
        // test that results have nutella
        WebElement amazonResultWebElement = driver.findElement(
                By.xpath("//div[@class='sg-col-14-of-20 sg-col-18-of-24 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']"));

        String actualResult = amazonResultWebElement.getText();
        String expectedWord = "nutella";
        Assert.assertTrue(actualResult.contains(expectedWord));

        ReusableMethods.takeElementScreenShot(amazonResultWebElement);
        amazonSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
        ReusableMethods.takeElementScreenShot(amazonSearchBox);




    }


}
