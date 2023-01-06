package day06_assertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertions {

    /*
    So far we have used if-else statements for our test cases but when we do that JUnit frame work
    can not understand if there is a problem with our test cases.
    So instead of using if-else statements we need use JUnit Assert methods:
    assertTrue, assertFalse, AssertEquals, AssertNotEquals

    By using premade Assert methods, JUnit will be able to report the result for us

        If test case is positive, the method we use should be also positive
     */



    int age1 = 60;
    int age2 = 66;
    int age3 = 70;

    // the limit age is 65

    @Test
    public void test01(){
        // can age2 retire?
        Assert.assertTrue(age2>65);
    }
    @Test
    public void test02(){
        // test that age1 can not retire
        Assert.assertFalse(age1>65);
    }
    @Test
    public void test03(){
        // can age3 retire?
        Assert.assertTrue("Age3 failed",age3>65);
    }


}
