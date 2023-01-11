package day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_MoveToElement extends TestBase {

    @Test
    public void test01() {

        //Let's create a new class: MouseActions3
        //1- https://www.amazon.com/
        //2- Move the mouse over the menu to open the “Account & Lists” menu in the upper right section.
        //3- Press the “Create a list” button
        //4- Test that "Your Lists" is written on the page that opens.

        //1- https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //2- Move the mouse over the menu to open the “Account & Lists” menu in the upper right section.
        Actions actions = new Actions(driver);

        WebElement accountAndListWebELement = driver.findElement(By.id("nav-link-accountList-nav-line-1"));

        ReusableMethods.wait(1);
        actions.moveToElement(accountAndListWebELement).perform();

        ReusableMethods.wait(1);

        //3- Press the “Create a list” button
        WebElement createListElement = driver.findElement(By.xpath("//span[text()='Create a List']"));
        createListElement.click();

        WebElement yourListsElement = driver.findElement(By.id("my-lists-tab"));

        Assert.assertTrue(yourListsElement.isDisplayed());


    }
}
