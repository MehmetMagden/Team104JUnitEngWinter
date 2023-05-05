package day22_writeExcelFile;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_JS_Executer2 extends TestBase {


    @Test
    public void test() {

        //
        driver.get("https://wisequarter.com/");

        WebElement goCareerPage = driver.findElement(By.xpath("//*[@class='fas fa-paper-plane']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", goCareerPage);


        // to go a web element we can use JS codes
        jse.executeScript("alert('we could not click on it');");


        goCareerPage.click();


    }

}
