package Gun05;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _06_SoftAssertVsHardAssert {

    @Test
    void hardAssert()
    {
        String s1="Merhaba";

        System.out.println("Hard Assert kontrol öncesi");
        Assert.assertEquals("Merhaba 123",s1, "HardAssert Sonucu");
        System.out.println("Hard Assert kontrol sonrasi");
    }

    @Test
    void softAssert()
    {
        String strHomePage="www.facebook.com/homepage";
        String strCartPage="www.facebook.com/cartpage";
        String strEditAccount="www.facebook.com/editaccountpage";

        SoftAssert _softAssert= new SoftAssert();

        _softAssert.assertEquals("www.facebook.com/homepage", strHomePage); // true
        System.out.println("assert 1");

        _softAssert.assertEquals("www.facebook.com/profile", strCartPage);  // false
        System.out.println("assert 2");

        _softAssert.assertEquals("www.facebook.com/settings", strEditAccount);  // false
        System.out.println("assert 3");

        _softAssert.assertAll();  // bütün assert sonuclarini isleme koyuyor.
        System.out.println("Aktiflik sonrasi");  // bu bölüm assertAll dan sonra oldugu ve öncesinde hata olustugu icin,
        // yazilamadi.
    }
}
