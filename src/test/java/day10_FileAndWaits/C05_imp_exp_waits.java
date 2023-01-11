package day10_FileAndWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_imp_exp_waits {

    //1. Create a class : WaitTest
    //2. Create two methods: implicitWaitTest() , explicitWaitTest()
    //
    // Test the following steps for both methods.
    //3. Go to https://the-internet.herokuapp.com/dynamic_controls.
    //4. Press the Remove button.
    //5. “It's gone!” Verify that the message is displayed.
    //6. Press the Add button
    //7. Test that it's back message appears

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void implicitWaitTest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //3. Go to https://the-internet.herokuapp.com/dynamic_controls.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Press the Remove button.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        //5. “It's gone!” Verify that the message is displayed.
        WebElement itsGoneTXTElement = driver.findElement(By.xpath("//p[@id='message']"));

        Assert.assertTrue(itsGoneTXTElement.isDisplayed());

        //6. Press the Add button
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //7. Test that it's back message appears

        String expectedText ="It's back!";
        String actualText = driver.findElement(By.xpath("//p[@id='message']")).getText();

        Assert.assertEquals(expectedText,actualText);


    }


    @Test
    public void explicitWaitTest(){




    }

    @After
    public void tearDown() {
        driver.quit();
    }





}
