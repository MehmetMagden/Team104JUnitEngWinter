package day22_writeExcelFile;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_JS_Executer extends TestBase {

    @Test
    public void test(){

        // go to the amazon webpage
        driver.get("https://www.amazon.com");

        //Click on giftCards by using JS Executer
        WebElement giftCardButton = driver.findElement(By.xpath("//a[text()='Gift Cards']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        ReusableMethods.wait(3);
        jse.executeScript("arguments[0].click();",giftCardButton);
        ReusableMethods.wait(3);






    }


}
