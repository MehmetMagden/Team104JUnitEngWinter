package day10_FileAndWaits;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_FileInputStream {

    @Test
    public void test01() throws FileNotFoundException {

        String filePath = "C:\\Users\\Maden\\Desktop\\Java.docx"; // not dynamic because it is using this computers user name

        FileInputStream fis = new FileInputStream(filePath);

        /*
        When we need to test that a file is downloaded to a computer, we need to know the path of this file.

        But this path may change in different computer so we need to create a dynamic path to execute our codes
        in different computers

        To do that we will use two different Java code blogs


         */


        System.out.println(System.getProperty("user.dir"));
        // returns C:\Users\Maden\IdeaProjects\com.Team104JUnit
        // gives the path of the class you are in

        System.out.println(System.getProperty("user.home"));
        // returns C:\Users\Maden
        // by using this part of the path, I can create a dynamic path for all computers

        // to go to the Destop, we need to add \\Destop to "C:\Users\Maden"

       // to create a dynamic path we first need to show dynamic part by System.getProperty("user.home").
        // It is like this for this computer  (C:\Users\Maden). It changes in every computer

        // second part is not dynamic, it will be same for all computers  "\\Desktop\\Java.docx"

        String dynamicFilePath = System.getProperty("user.home")+ "\\Desktop\\Java.docx";




    }



}
