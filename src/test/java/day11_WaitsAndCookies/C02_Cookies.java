package day11_WaitsAndCookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C02_Cookies extends TestBase {

    //Create a new class : cookiesAutomation
    //1- Go to Amazon homepage
    //2- list all cookies
    //3- Test that the number of cookies on the page is greater than 5
    //4- Test the value of the cookie with the name i18n-prefs is USD
    //5- Create a cookie with the name "my favorite cookie" and the value "chocolate" and add it to the page
    //6- test that the cookie you added is added to the page
    //7- Delete the cookie whose name is skin and test it is deleted
    //8- delete all cookies and test if they are deleted


    @Test
    public void test01(){

        //1- Go to Amazon homepage

        driver.get("https://www.amazon.com");
        //2- list all cookies
        Set<Cookie> cookieSet= driver.manage().getCookies();

        int orderNo = 1;
        for (Cookie eachCookie: cookieSet
             ) {
            System.out.println(orderNo +" "+eachCookie);
            orderNo++;
        }

        //3- Test that the number of cookies on the page is greater than 5
        Assert.assertTrue(cookieSet.size()>5);

        //4- Test the value of the cookie with the name i18n-prefs is USD
        String expectedCookieValue = "USD";
        String actualCookieValue ="";

        for (Cookie eachCookie: cookieSet
             ) {
            if(eachCookie.getName().equals("i18n-prefs")){
                actualCookieValue=eachCookie.getValue();
            }
        }

        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        //5- Create a cookie with the name "my favorite cookie" and the value "chocolate" and add it to the page

        Cookie theBestCookie = new Cookie("my favorite cookie","chocolate");
        driver.manage().addCookie(theBestCookie);

        //6- test that the cookie you added is added to the page

        cookieSet = driver.manage().getCookies();
        int isItThere=0;
        for (Cookie eachCookie: cookieSet
             ) {
            if(eachCookie.getName().equals("my favorite cookie")){
                isItThere++;
            }
        }

        Assert.assertTrue(isItThere>0);




        //7- Delete the cookie whose name is skin and test it is deleted

        driver.manage().deleteCookieNamed("skin");

        cookieSet = driver.manage().getCookies();
         isItThere=0;
        for (Cookie eachCookie: cookieSet
        ) {
            if(eachCookie.getName().equals("skin")){
                isItThere++;
            }
        }

        Assert.assertTrue(isItThere==0);


        orderNo = 1;
        for (Cookie eachCookie: cookieSet
        ) {
            System.out.println(orderNo +" "+eachCookie);
            orderNo++;
        }

        //8- delete all cookies and test if they are deleted

        driver.manage().deleteAllCookies();
        cookieSet=driver.manage().getCookies();

        Assert.assertTrue(cookieSet.size()==0);





    }
}
