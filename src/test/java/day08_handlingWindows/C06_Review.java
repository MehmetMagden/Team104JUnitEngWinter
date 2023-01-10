package day08_handlingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C06_Review extends TestBase {

    //1. Go to http://zero.webappsecurity.com/
    //2. Press the Sign in button
    // 3. Type “username” in the Login box
    // 4. Type “password.” in the Password box.
    // 5. Press the Sign in button
    //6. Go to the Pay Bills page
    //7. Press the “Purchase Foreign Currency” key
    //8. Select Eurozone from the “Currency” drop down menu
    //9. Enter a number in the “amount” box
    //10. Test that “US Dollars” is not selected
    //11. Select the “Selected currency” button
    //12. Press the “Calculate Costs” button then the “purchase” button
    //13. “Foreign currency cash was successfully purchased.” Check that the text is visible.

    @Test
    public void test01(){
        //1. Go to http://zero.webappsecurity.com/
        driver.get("http://zero.webappsecurity.com/");

        //2. Press the Sign in button
        driver.findElement(By.id("signin_button")).click();

        //3. Type “username” in the Login box
        driver.findElement(By.id("user_login")).sendKeys("username");

        //4. Type “password.” in the Password box.
        driver.findElement(By.id("user_password")).sendKeys("password");

        //5. Press the Sign in button
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        //6. Go to the Pay Bills page
        driver.navigate().back();
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //7. Press the “Purchase Foreign Currency” key
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();

        //8. Select Eurozone from the “Currency” drop down menu
        WebElement dropDown = driver.findElement(By.id("pc_currency"));
        Select select = new Select(dropDown);
        select.selectByValue("EUR");

        //9. Enter a number in the “amount” box
        driver.findElement(By.id("pc_amount")).sendKeys("200");

        //10. Test that “US Dollars” is not selected
        WebElement usDolRadioBox = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(usDolRadioBox.isSelected());

        //11. Select the “Selected currency” button
        driver.findElement(By.id("pc_inDollars_false")).click();

        //12. Press the “Calculate Costs” button then the “purchase” button
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();

        //13. “Foreign currency cash was successfully purchased.” Check that the text is visible.
        WebElement text = driver.findElement(By.id("alert_content"));
        Assert.assertTrue(text.isDisplayed());
    }
}
