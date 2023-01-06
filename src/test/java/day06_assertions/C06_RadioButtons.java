package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButtons {

    static WebDriver driver;

    @BeforeClass
    public static void setUp (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }


    //Create the required structure and complete the following task.
    // a. Go to the given web page.
    //      https://facebook.com
    // b. Accept cookies
    // c. Press the Create an account button
    // D. Locate the radio button elements and choose the one that suits you

    @Test
    public void test01() throws InterruptedException {

        // a. Go to the given web page.
        //      https://facebook.com

        driver.get("https://facebook.com");

        // b. Accept cookies // no cookies for me

        // c. Press the Create an account button
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // D. Locate the radio button elements and choose the one that suits you
        WebElement radioBoxF = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement radioBoxM = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement radioBoxS = driver.findElement(By.xpath("//input[@value='-1']"));

        radioBoxM.click();

        Thread.sleep(5000);


    }



}
