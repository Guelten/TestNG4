package Gun02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Dependency {

    // arabanin hareketleri : start, drive, park, stop hareket sirasi
    // (dependsOnMethods={}) : bir birine bagliyor.

    @Test
    void startCar()
    {
        System.out.println("startCar");
        //Assert.fail();      // Assert.fail() olunca calismiyor / kapatinca "priority" kaldirmaliyiz.
    }


    @Test(dependsOnMethods = {"startCar"})  // bu testin calismasi, startCar in hatasiz calismasina bagimli
    void driveCar()
    {
        System.out.println("driveCar");
    }


    @Test(dependsOnMethods = {"startCar", "driveCar"})
    void parkCar()
    {
        System.out.println("parkCar");
    }


    @Test(dependsOnMethods = {"parkCar"}, alwaysRun = true)  // alwaysRun = true : bagimliliklari var ama hata cikarsa da yine calisir.
    void stopCar()
    {
        System.out.println("stopCar");
    }

    // ayni seviyedeki testler icin priority verilebilir.
    // bagimli testler, direk metodundan calistirdiginizda bagimli oldugu metod zincirinde 2 üst kadar otomatik cagirip calisabilir.

}
