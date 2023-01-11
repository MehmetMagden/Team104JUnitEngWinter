package day10_FileAndWaits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTest extends TestBase {

    @Test
    public void test01(){

        //1. Let's create a class under the Tests package: C04_FileDownload
        //Go to https://www.selenium.dev/downloads/.
        //3. Download the logo.png file my hand
        //4 . Let 's test if the file was downloaded successfully

        driver.get("https://www.selenium.dev/downloads/");

        driver.findElement(By.linkText("64 bit Windows IE")).click();


        ReusableMethods.wait(20);

        //String filePath="C:\\Users\\Maden\\Downloads\\IEDriverServer_x64_4.7.0.zip"; // this is not dynamic file path
        String filePath=System.getProperty("user.home")+"\\Downloads\\IEDriverServer_x64_4.7.0.zip"; // this is dynamic path

        Assert.assertTrue(Files.exists(Paths.get(filePath)));





    }


}
