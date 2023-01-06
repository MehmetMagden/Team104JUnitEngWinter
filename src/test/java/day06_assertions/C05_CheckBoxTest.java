package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_CheckBoxTest {

    //Create the required structure and complete the following task.
    // a. Go to the given web page.
    //      https://the-internet.herokuapp.com/checkboxes
    // b. Locate the checkbox1 and checkbox2 elements.
    // c. Click the checkbox if Checkbox1 is not selected
    // D. Click the checkbox if Checkbox2 is not selected
    // test that all checkboxes are selected

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

    @Test
    public void test01 () throws InterruptedException {
        // a. Go to the given web page.
        //      https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // b. Locate the checkbox1 and checkbox2 elements.

        WebElement cb1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement cb2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        // c. Click the checkbox if Checkbox1 is not selected

        if (!cb1.isSelected()){
            cb1.click();
        }

        // D. Click the checkbox if Checkbox2 is not selected

        if (!cb2.isSelected()){
            cb2.click();
        }

        // test that all checkboxes are selected
        Assert.assertTrue(cb1.isSelected());
        Assert.assertTrue(cb2.isSelected());


    }




}
