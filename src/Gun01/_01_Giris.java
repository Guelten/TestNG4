package Gun01;

import org.testng.annotations.Test;

public class _01_Giris {

    // Eger herhangi bir siralama verilmezse metod isimlerinin alfabetik calisiyor
    // (priority) ile siralama yapilir.
    @Test(priority = 1)
    void webSitesiniAc()
    {
        System.out.println("driver tanimlandi ve web sitesi acildi.");
    }


    @Test(priority = 2)
    void loginIsleminiYap()
    {
        System.out.println("login test islemleri yapildi");
    }


    @Test(priority = 3)
    void driveriKapat()
    {
        System.out.println("driver kapatildi ve cikildi");
    }
}
