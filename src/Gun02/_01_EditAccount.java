package Gun02;

/*
  Senaryo
  1- Siteyi açınız.
  2- Edit Account sayfasına ulaşınız.
  3- Ad ve soyadı değiştirip tekrar kaydedidiniz.
 */


import Utils.BaseDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _01_EditAccount extends BaseDriver{

    By editAccount= By.linkText("Edit Account");
    By firstName= By.id("input-firstname");
    By lastName= By.id("input-lastname");
    By submitButton= By.cssSelector("input[type='submit']");

    @Test
    void editAccount(){
        editAccountTest("saraGül", "sonbahar");
        Tools.Bekle(2);
        editAccountTest("sara", "Mueller");
    }

    @Test
    void editAccountTest(String ad, String soyad)
    {
        WebElement edit = driver.findElement(By.linkText("Edit Account"));
        edit.click();

        WebElement txtFirstName= driver.findElement(firstName);
        txtFirstName.clear();
        txtFirstName.sendKeys("saraGül");

        WebElement txtLastName= driver.findElement(lastName);
        txtLastName.clear();
        txtLastName.sendKeys("sonbahar");

        WebElement bntSubmit= driver.findElement(submitButton);
        bntSubmit.click();

        Tools.successMessageValidation();

    }

}
