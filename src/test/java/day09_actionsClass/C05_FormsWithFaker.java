package day09_actionsClass;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_FormsWithFaker extends TestBase {


    @Test
    public void test01(){

        // go to the https://www.facebook.com
        // click on "create a new account"
        // fill the texboxes
        //test that text "Kaydın yapılırken bir hata oluştu. Lütfen kaydolmayı yeniden dene." is visible

        // go to the facebook
        driver.get("https://www.facebook.com");

        // click on "create a new account"
        WebElement createNewAccountButtonElement = driver
                .findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        createNewAccountButtonElement.click();

        // fill the texboxes
        WebElement firstNameTextBoxElement = driver.findElement(By.name("firstname"));

        Faker faker = new Faker();
        Actions actions = new Actions(driver);

        firstNameTextBoxElement.click();
        String fakeEmailAddress = faker.internet().emailAddress();
        System.out.println(fakeEmailAddress);

        actions.sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmailAddress)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmailAddress)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys("1900")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();


        driver.findElement(By.name("websubmit")).click();

        WebElement errorTxtElement = driver.findElement(By.id("reg_error_inner"));


        ReusableMethods.wait(10);
        Assert.assertTrue(errorTxtElement.isDisplayed());


        ReusableMethods.wait(4);








    }
}
