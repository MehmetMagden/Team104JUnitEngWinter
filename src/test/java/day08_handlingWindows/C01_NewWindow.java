package day08_handlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C01_NewWindow {



    /*

     With selenium 4, new feature has added to selenium.

     If we want we can create new tabs by using selenium codes.
     When we do that, driver also switches to new tab.

     But if we want to return previous tabs, we need to store windowHandle Values
     in the tabs
     Then in the next steps if we are asked to return first tabs, we can use
     this WHV to return.
     select.switchTo.window(WHV)


     --- if we are planing to work with tabs we need to store them when we are in them
     --- if we create a new tab ( without clicking on anything) driver will follow us to new tab


     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));

    }

    @After
    public void tearDown(){

        driver.quit(); // instead of close we used "quit" method to close all opened tabs
    }


    @Test
    public void test01(){

        // go to the amazon and thest that we are in amazon

        driver.get("https://www.amazon.com");

        String amazonTabValue = driver.getWindowHandle();

        String expectedKey = "Amazon";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedKey));



        //Test that after visiting "https://wisequarter.com" , Url contains "wisequarter"
        // If we want to open a new tab at will we can use this command
        driver.switchTo().newWindow(WindowType.TAB); // If we open a new tab (at will) by using this code, driver also will switch to new tab.
        driver.get("https://www.wisequarter.com");

        String actualUrl = driver.getCurrentUrl();
        String expectedword = "wisequarter";

        Assert.assertTrue(actualUrl.contains(expectedword));

        // Test that after returning Amazon Tab, test the url
        driver.switchTo().window(amazonTabValue); // driver will switch to amazonTab
        String expectedKeyWord = "amazon";
        String actualAmazonUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualAmazonUrl.contains(expectedKeyWord));


        // to save second window handle value
       Set<String> handleUniqueValues = driver.getWindowHandles();
        String secondTabHandleValue ="";
        for (String each: handleUniqueValues
             ) {
            if (!each.equals(amazonTabValue)){
               secondTabHandleValue = each;

            }
        }

        // by these to different tabs' handle values, driver can switch to every tabs


    }




}
