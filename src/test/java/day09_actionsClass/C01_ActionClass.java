package day09_actionsClass;

import io.netty.util.internal.ReferenceCountUpdater;
import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C01_ActionClass extends TestBase {


    @Test
    public void test01(){

        //1- Let's create a new class: MouseActions1
        //2- Go to https://the-internet.herokuapp.com/context_menu
        //3- Right click on the drawn area
        //4- Test that the text in Alert is “You selected a context menu”.
        //5- Let's close the alert by saying OK
        //6- Click on Elemental Selenium link
        //7- Let's test that "Elemental Selenium" is written in the h1 tag on the page that opens.

        //2- Go to https://the-internet.herokuapp.com/context_menu
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Right click on the drawn area
        WebElement areaElement = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);

        actions.contextClick(areaElement).perform();

        //4- Test that the text in Alert is “You selected a context menu”.
        String expectedText ="You selected a context menu";
        String actualText =driver.switchTo().alert().getText();

        Assert.assertEquals(expectedText,actualText);

        //5- Let's close the alert by saying OK
        driver.switchTo().alert().accept();


        //6- Click on Elemental Selenium link

        String firstTabWHV = driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click(); // tag shuld be a and there should be a text


        //7- Let's test that "Elemental Selenium" is written in the h1 tag on the page that opens.
        Set<String> allHandleValues =driver.getWindowHandles();

        String secondTabWHV ="";
        for (String each: allHandleValues
             ) {
            if (!each.equals(firstTabWHV)){
                secondTabWHV = each;
            }
        }

        driver.switchTo().window(secondTabWHV);

        String expectedH1TagText ="Elemental Selenium";
        String actualH1TagText =driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedH1TagText,actualH1TagText);


        ReusableMethods.wait(5);


    }




}
