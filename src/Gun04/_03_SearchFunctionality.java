package Gun04;

/*
       Senaryo ;
       1- Siteyi açınız.
       2- mac kelimesini göndererek aratınız.
       3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
       4- aynı işlemi samsung için de yapınız
     */

import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _03_SearchFunctionality extends BaseDriver {

    @Parameters("aranacakKelime")
    @Test
    void SearchFunction(String aranacakKelime){

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(aranacakKelime);

        WebElement searchButton = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> captions = driver.findElements(By.cssSelector("div[class='caption']>h4"));

        for (WebElement e : captions)
            Assert.assertTrue(e.getText().toLowerCase().contains(aranacakKelime));
    }

}
