package Rough;

import org.testng.annotations.*;
import org.testng.annotations.BeforeSuite;

public class TestNgPractice {

    @BeforeSuite(groups = {"windows.checkintest","linux.checkintest"})
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @AfterSuite(groups = {"windows.checkintest","linux.checkintest"})
    public void afterSuite(){
        System.out.println("After Suite");
    }
    @BeforeTest(groups = {"windows.checkintest","linux.checkintest"})
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @AfterTest(groups = {"windows.checkintest","linux.checkintest"})
    public void afterTest(){
        System.out.println("After Test");
    }
    @BeforeClass(groups = {"windows.checkintest","linux.checkintest"})
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @AfterClass(groups = {"windows.checkintest","linux.checkintest"})
    public void afterClass(){
        System.out.println("After Class");
    }

    @Parameters({"firstName"})
    @Test(priority = 1, groups = {"windows.checkintest"})
    public void test1(String firstName) throws Exception {
        System.out.println("Test1");
        System.out.println(firstName);
//        throw new Exception();
    }
//    @Ignore
    @Test(groups = {"linux.checkintest"})
    public void test2(){
        System.out.println("Test2");
    }
    @Test(groups = {"windows.checkintest"})
    public void test3(){
        System.out.println("Test3");
    }
}
