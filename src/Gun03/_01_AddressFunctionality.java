package Gun03;

/*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son adresi siliniz.
 */

import Utils.BaseDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class _01_AddressFunctionality extends BaseDriver {

    @Test
    void addAddress()
    {
        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        WebElement newAddress=driver.findElement(By.linkText("New Address"));
        newAddress.click();

        WebElement firsName=driver.findElement(By.id("input-firstname"));
        firsName.sendKeys("Ahmet");

        WebElement lastname=driver.findElement(By.id("input-lastname"));
        lastname.sendKeys("Demir");

        WebElement company=driver.findElement(By.id("input-company"));
        company.sendKeys("Techno Study");

        WebElement address1=driver.findElement(By.id("input-address-1"));
        address1.sendKeys("21a London Road");

        WebElement address2=driver.findElement(By.id("input-address-2"));
        address2.sendKeys("RG2 5BJ");

        WebElement city=driver.findElement(By.id("input-city"));
        city.sendKeys("Reading");

        WebElement postCode=driver.findElement(By.id("input-postcode"));
        postCode.sendKeys("12345");

        WebElement country=driver.findElement(By.id("input-country"));
        Select countrySelect= new Select(country);
        //countrySelect.selectByVisibleText("Turkey");  //böylede yapilabilinir.
        countrySelect.selectByIndex(10);  // selectByVisibleText, selectValue implicitly wait ile calisti
        // selectByVisibleText, selectValue ile sorunsuz calisir ve beklemeye ihtiyaci olmaz

        WebElement option = driver.findElement(By.cssSelector("select[id='input-zone']>option"));
        wait.until(ExpectedConditions.stalenessOf(option));  // stale element durumu düzelene kadar bekle

        WebElement State=driver.findElement(By.id("input-zone"));
        Select StateSelect= new Select(State);
        //StateSelect.selectByVisibleText("Adana");  // böylede yapilabilinir.
        StateSelect.selectByIndex(6);// selectByVisibleText, selectValue implicitly wait ile calisti
        // selectByIndex implicitly wait ile calismiyor.
        // selectByVisibleText, selectValue ile sorunsuz calisir ve beklemeye ihtiyaci olmaz

        WebElement defadres=driver.findElement(By.cssSelector("label [name='default'][value='1']"));
        defadres.click();

        WebElement ctn=driver.findElement(By.cssSelector("input[type='submit']"));
        ctn.click();

        Tools.successMessageValidation();

    }

    @Test(dependsOnMethods = {"addAddress"})
    void editAddress()
    {
        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> editAll = driver.findElements(By.linkText("Edit"));
        WebElement sonEdit = editAll.get(editAll.size()-1); // son edit
        sonEdit.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys("Mehmet");

        WebElement lastname = driver.findElement(By.id("input-lastname"));
        lastname.clear();
        lastname.sendKeys("Yilmaz");

        WebElement ctn = driver.findElement(By.cssSelector("input[type='submit']"));
        ctn.click();

        Tools.successMessageValidation();

    }

    @Test(dependsOnMethods = {"editAddress"})
    void deleteAddress()
    {
        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> deleteAll = driver.findElements(By.linkText("Delete"));
        WebElement silinebilirAdress = deleteAll.get(deleteAll.size()-2);

        silinebilirAdress.click();
        Tools.successMessageValidation();

    }

}
