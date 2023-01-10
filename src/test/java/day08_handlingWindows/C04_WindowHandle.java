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
import java.util.Set;

public class C04_WindowHandle {

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

        // go to the "https://the-internet.herokuapp.com/iframe"
        // click on the "elemental selenium"
        //when we click on it a new tab will open so we need to save WHV of first tab

        driver.get("https://the-internet.herokuapp.com/iframe");

        String firstTabHandleValue = driver.getWindowHandle();

        // to work on second tab we need our driver on second tab we need to switch driver to second tab

        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        Set<String> handleSetValues =driver.getWindowHandles();

        String secondTabHandleValue="";

        for (String each: handleSetValues
             ) {
            if (!each.equals(firstTabHandleValue)){
                secondTabHandleValue = each;
            }
        }

        driver.switchTo().window(secondTabHandleValue);

        //Verify that the biggest text is "Elemental Selenium"

        String expectedValueOfBiggestText = "Elemental Selenium";
        String actualValueOfBiggestText = driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedValueOfBiggestText,actualValueOfBiggestText);

        // then go back to previous tab then test that there is a text  "An iFrame containing the TinyMCE WYSIWYG Editor"

        driver.switchTo().window(firstTabHandleValue);

        String expectedStr = "An iFrame containing the TinyMCE WYSIWYG Editor";
        String actualStr = driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedStr,actualStr);


    }



}
