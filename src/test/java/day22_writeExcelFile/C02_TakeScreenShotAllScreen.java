package day22_writeExcelFile;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_TakeScreenShotAllScreen extends TestBase {

    @Test
    public void test(){

        // go to the amazon page
        driver.get("https://www.amazon.com");

        // search for nutella
        WebElement amazonSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
        amazonSearchBox.sendKeys("utella"+ Keys.ENTER);

        // test that results have nutella
        WebElement amazonResultWebElement = driver.findElement(
                By.xpath("//div[@class='sg-col-14-of-20 sg-col-18-of-24 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']"));

        String actualStr = amazonResultWebElement.getText();
        String expectedWord = "utella";

        Assert.assertTrue(actualStr.contains(expectedWord));

        // take a screenshot of all page

        ReusableMethods.takeFullScreenShot(driver);


    }

}
