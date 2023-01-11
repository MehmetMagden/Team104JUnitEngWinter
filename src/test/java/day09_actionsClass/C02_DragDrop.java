package day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_DragDrop extends TestBase {

    //Let's create a new class: MouseActions2
    //1- Let's go to https://demoqa.com/droppable
    //2- Let's hold the "Drag me" button and drop it above the "Drop here" box
    //3-  Test that,Instead of “Drop here” text “Dropped!” text is there

    @Test
    public void test01() {

        //1- Let's go to https://demoqa.com/droppable
        driver.get("https://demoqa.com/droppable");

        //2- Let's hold the "Drag me" button and drop it above the "Drop here" box
        Actions actions = new Actions(driver);
        WebElement dragMeButton = driver.findElement(By.xpath("//div[text()='Drag me']"));
        WebElement droppableButton = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(dragMeButton, droppableButton).perform();

        //3-  Test that,Instead of “Drop here” text “Dropped!” text is there
        String expectedSTR = "Dropped!";
        String actualSTR = driver.findElement(By.id("droppable")).getText();

        Assert.assertEquals(expectedSTR, actualSTR);
        ReusableMethods.wait(5);


    }

}
