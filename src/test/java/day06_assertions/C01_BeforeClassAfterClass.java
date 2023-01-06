package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClassAfterClass {

    // Create 3 different methods for these tasks

    //go to the "https://wwww.amazon.com // test that we are successful
    // search for "Nutella" and test that results have "Nutella"
    // test if there are more than 50 results
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
    public void test01(){
        //go to the "https://wwww.amazon.com // test that we are successful
        driver.get("https://wwww.amazon.com");

        String expectedWord = "DAmazon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedWord)){
            System.out.println("Amazon Title Tests PASSED");
        }else {
            System.out.println("Amazon Title Tests FAILED");
        }
    }

    @Test
    public void test02(){
        // search for "Nutella" and test that results have "Nutella"
        WebElement amazonSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
        amazonSearchBox.sendKeys("Nutella"+ Keys.ENTER);

        WebElement resultText = driver.findElement(By.xpath("//div[@class='s-desktop-width-max sg-row-align-items-center sg-row']"));

        String expectedKeyWord = "ANutella";
        String actualText = resultText.getText();

        if( actualText.contains(expectedKeyWord)){
            System.out.println("Nutella Search Test PASSED");
        }else {
            System.out.println("Nutella Search Test FAILED");
        }

    }

    @Test
    public void test03(){

        // test if there are more than 50 results
        WebElement resultText = driver.findElement(By.xpath("//div[@class='s-desktop-width-max sg-row-align-items-center sg-row']"));
        String resultNumberStr =resultText.getText().split(" ")[2]; // java
        int actualResultNumber = Integer.parseInt(resultNumberStr);

        int expectedResultNumber= 500;

        if (actualResultNumber>expectedResultNumber){
            System.out.println("Result Number Test PASSED");
        }  else {
            System.out.println("Result Number Test FAILED");
        }

    }






}
