package day22_writeExcelFile;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_TakeSSFullScreen extends TestBase {

    @Test
    public void test() {

        // go to the wise quarter
    driver.get("https://wisequarter.com/");
        // test that you are in
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl = "https://wisequarter.com/";

        Assert.assertEquals(expectedUrl,actualUrl);

        // take a SS
        ReusableMethods.takeFullScreenShot(driver);

    }


}
