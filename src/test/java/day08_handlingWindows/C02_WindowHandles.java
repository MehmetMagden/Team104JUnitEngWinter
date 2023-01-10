package day08_handlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandles {

    WebDriver driver;

    @Before
    public void setUp (){

        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void tearDown(){

        driver.quit();
    }


    @Test
    public void test01() throws InterruptedException {


        //● Go to https://the-internet.herokuapp.com/windows.
        driver.get("https://the-internet.herokuapp.com/windows");
        String firstTab = driver.getWindowHandle();

        //● Verify that the text on the page is “Opening a new window”.

        String expectedSTR = "Opening a new window";
        String actualSTR=driver.findElement(By.tagName("h3")).getText();

        Thread.sleep(3000);
        Assert.assertEquals(expectedSTR,actualSTR);

        //● Verify that the page title is “The Internet”.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Thread.sleep(3000);
        Assert.assertEquals(expectedTitle,actualTitle);

        //● Click the Click Here button.

        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        //● Verify that the title of the new window that opens is “New Window”.

        Set<String> tabsHandleValues = driver.getWindowHandles();

        String secondTabValue ="";
        for (String each:tabsHandleValues
             ) {
            if (!each.equals(firstTab)){
                secondTabValue=each;

            }
        }

        driver.switchTo().window(secondTabValue);

        String expectedTitle2 ="New Window";
        String actualTitle2 = driver.getTitle();

        Thread.sleep(3000);
        Assert.assertEquals(expectedTitle2,actualTitle2);


        //● Verify that the text on the page is “New Window”.

        String expectedText2 =  "New Window";
        String actualText2 = driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedText2,actualText2);


        //● After returning to the previous window, the page title is “The Internet”. verify.

        driver.switchTo().window(firstTab);

        String expectedTitleOfFirstTab = "The Internet";
        String actualTitleOfFirstTab = driver.getTitle();

        Assert.assertEquals(expectedTitleOfFirstTab,actualTitleOfFirstTab);



        /*
            when an uncontroled tab is opend
            1- we need to save first tab WHV
            2- By using getWindowHandles, we will save the set which has all tabs' values
            3- by using a foreachloop for this set, we will save the handle value which is different than the first one

         */

    }


}
