package day08_handlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BasicAuthentication {

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
        //1- Create a class: BasicAuthentication
        //2- Go to https://the-internet.herokuapp.com/basic_auth
        driver.get("https://the-internet.herokuapp.com/basic_auth");

        //3- Do the authentication using the following method and test data
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //Html command: https://username:password@URL
        //Username: admin
        //password: admin

        //4- Verify that the page has been successfully entered

        String expectedStr = "Congratulations";
        String actualStr = driver.findElement(By.tagName("p")).getText();

        Assert.assertTrue(actualStr.contains(expectedStr));

        Thread.sleep(3300);

    }

}
