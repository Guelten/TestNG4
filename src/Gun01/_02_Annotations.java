package Gun01;

import org.testng.annotations.*;

public class _02_Annotations {

    /*
        @BeforeClass      -->   Class ın başında çalışacak   (driver işlemleri)
           @BeforeMethod  -->   Her metoddan(test metodları) önce çalışacak
               @Test      -->   testlerin çalıştığı metodlar
               @Test      -->   testlerin çalıştığı metodlar
           @AfterMethod   -->   Her metoddan sonra çalışacak
        @AfterClass       -->   Class ın çalışmasının sonunda çalışacak (driver kapat)
     */

    @BeforeClass
    void beforeClass()
    {
        System.out.println("Her class dan SONRA calisacak"); // driver ve diger test öncesi bütün islemler
    }

    @BeforeMethod
    void beforeMethod()
    {
        System.out.println("Her method dan ÖNCE calisacak");
    }

    @AfterMethod
    void afterMethod()
    {
        System.out.println("Her method dan SONRA calisacak");
    }

    @AfterClass
    void afterClass()
    {
        System.out.println("Her class dan SONRA calisacak"); // driver kapat vs ..
    }

    @Test
    void test1()
    {
        System.out.println("test 1 calisti");
    }

    @Test
    void test2()
    {
        System.out.println("test 2 calisti");
    }

}
