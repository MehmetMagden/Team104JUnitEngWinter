package day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_KeyboardActions extends TestBase {

    @Test
    public void test01() {

//1 - Let's create a Class KeyboardActions1
//2 - Go to https://www.amazon.com
//3 - Type Samsung A71 using actions methods in the search box and press Enter to search
//4 - test that the search is completed in amazon website

        //2 - Go to https://www.amazon.com
        driver.get("https://www.amazon.com");

        //3 - Type Samsung A71 using actions methods in the search box and press Enter to search
        Actions actions = new Actions(driver);

        driver.findElement(By.id("twotabsearchtextbox")).click();

        actions.keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();

        //4 - test that the search is completed in amazon website
        WebElement resultTextElement = driver.findElement(By
                .xpath("//*[@class='s-desktop-width-max sg-row-align-items-center s-wide-grid-style-t1 s-wide-grid-style sg-row']"));

        String expectedResultText = "Samsung A71";
        String actualResultText = resultTextElement.getText();

        Assert.assertTrue(actualResultText.contains(expectedResultText));

    }
}
