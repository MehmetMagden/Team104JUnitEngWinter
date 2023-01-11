package day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class Q01 extends TestBase {

    @Test
    public void test01(){

        //Create new Class ActionsClassHomeWork
        //1- Go to "http://webdriveruniversity.com/Actions" page
        //2- Hover over Me First" box
        //3- Click on "Link 1"
        //4- Print the popup message
        //5- Close the popup by saying ok
        //6- Press and hold the “Click and hold” box
        //7-Print the text that appears in the "Click and hold" box
        //8- Double click the “Double click me” button

        //1- Go to "http://webdriveruniversity.com/Actions" page
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" box
        Actions actions = new Actions(driver);
        WebElement firstHoverElement = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));

        actions.moveToElement(firstHoverElement).perform();


        //3- Click on "Link 1"
        driver.findElement(By.xpath("//a[text()='Link 1']")).click();

        String expectedAlertTXT1 = "Well done you clicked on the link!";
        String actualAlertText1 = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertTXT1,actualAlertText1);

        //4- Print the popup message
        System.out.println(actualAlertText1);

        //5- Close the popup by saying ok
        driver.switchTo().alert().accept();


        ReusableMethods.wait(5);






    }
}
