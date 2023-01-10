package day08_handlingWindows;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_FirstTestBaseTest extends TestBase {

    @Test
    public void test01() {

        // go to the amazon
        driver.get("https://www.amazon.com");

        // verify that you are in amazon
        String expectedWord = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedWord));

        ReusableMethods.wait(3);


    }
}
