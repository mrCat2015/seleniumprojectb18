package test.day06_testng_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGPractice {
    @BeforeClass
    public void before_Class(){
        System.out.println("BeforeClass is running! ----------------------");
    }
    @AfterClass
    public void after_class(){
        System.out.println("AfterClass is running!------------------------");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method is running...");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After method is running...");
    }

    @Test
    public static void test1(){
        System.out.println("Test1 running...");

        String actualTitle = "Homepage"; //driver.getTitle()
        String expectedTitle = "Homepage";

        Assert.assertEquals(actualTitle, expectedTitle);

     //   if(actualTitle.equals(expectedTitle)){
     //       System.out.println("Title verification passed!");
     //   }else{
     //       System.out.println("Title verification failed!!!");
     //   }
;
    }

    @Test
    public void test2(){
        System.out.println("Test2 is running...");

        Assert.assertEquals("string1", "string2", "String verification on test2 failed");
    }
    @Test
    public void test3(){
        System.out.println("Test3 is running...");

        String actualTitle = "Amazon prime";
        String expectedTitle = "prime";
        String testString = "jukghbkb";

        //if the boolean value we pass in assertTrue is "true", assertion will pass
        //else it will fail
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //Assert.assertFalse(actualTitle.contains(testString));
    }
}
