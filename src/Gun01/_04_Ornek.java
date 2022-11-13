package Gun01;

import Utils.BaseDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_Ornek extends BaseDriver{

    @Test
    void loginTest()
    {
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        System.out.println("login test");
        WebElement inbutEmail= driver.findElement(By.id("input-email"));
        inbutEmail.sendKeys("saramul@gmail.com");

        WebElement password= driver.findElement(By.id("input-password"));
        password.sendKeys("sara2022+");

        WebElement loginBtn= driver.findElement(By.cssSelector("input[type='submit']"));
        loginBtn.click();

        Assert.assertEquals(driver.getTitle(),"My Account", "Login basarisiz");

        Tools.Bekle(5);

    }

}
