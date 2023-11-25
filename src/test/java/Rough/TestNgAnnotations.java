package Rough;

import org.testng.annotations.*;

public class TestNgAnnotations {


    @BeforeSuite
    public void beforesuite(){
        System.out.println("beforesuite");
    }
    @BeforeTest
    public void beforetest(){
        System.out.println("beforetest");
    }
    @BeforeClass
    public void beforeclass(){
        System.out.println("beforeclass");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod");
    }

    @Test
    public void testMethod1(){
        System.out.println("test2");
    }

    @Test
    public void testMethod2(){
        System.out.println("test1");
    }

}
