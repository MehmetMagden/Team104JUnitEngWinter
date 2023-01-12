package day11_WaitsAndCookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C03_Tables extends TestBase {

    @Test
    public void test01(){

        // 1- go to the https://www.amazon.com
        driver.get("https://www.amazon.com");

        // 2- go to the bottom of the page
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        // 3- test that the webTable has 9 rows

        List<WebElement> rowNumber = driver.findElements(By.xpath("//table//tr"));

        Assert.assertEquals(10,rowNumber.size()); // it changes

        // 4- print all lines

        for (WebElement each : rowNumber
             ) {
            System.out.println(each.getText());
        }

        // test that there are 13 column in table
        List<WebElement> columnNumberList = driver.findElements(By.xpath("//table//tr[1]/td"));

        Assert.assertEquals(14,columnNumberList.size()); // // it changes

        // print 5. column in the table

        List<WebElement> column5Elements = driver.findElements(By.xpath("//table//tr/td[5]"));

        for ( WebElement each: column5Elements
             ) {
            System.out.println("------------------");
            System.out.println(each.getText());
        }

        // print the element row 5 column 9
        WebElement row5column8 = driver.findElement(By.xpath("//table//tr[5]/td[9]"));
        System.out.println(row5column8.getText());

        int row =5;
        int column =9;

        WebElement dynamicTableElement = getElement(row,column);
        System.out.println(dynamicTableElement.getText());










    }

    public WebElement getElement(int row, int column) {

        String dynamicXpath = "//table//tr["+row+"]/td["+column+"]";

        WebElement desiredOne = driver.findElement(By.xpath(dynamicXpath));



        return desiredOne;

    }

}
