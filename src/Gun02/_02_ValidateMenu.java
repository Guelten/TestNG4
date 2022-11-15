package Gun02;

/*
  Senaryo
  1- Siteyi açınız.
  2- Top Menudeki menu elemanlarının olduğunu doğrulayınız.(menuValidation)
  3- Desktops, Laptops & Notebooks, Components, Tablets, Software, Phones & PDAs, Cameras, MP3 Players
 */

import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class _02_ValidateMenu extends BaseDriver {

    @Test(groups = "SmokeTest")
    void menuValidation()
    {
        List<WebElement> menuActualList = driver.findElements(By.cssSelector("ul[class='nav navbar-nav']>li"));

//        for (WebElement e : menuActualList)
//            System.out.println(e.getText());

        List<String> menuExpectedList = new ArrayList<>();
        menuExpectedList.add("Desktops");
        menuExpectedList.add("Laptops & Notebooks");
        menuExpectedList.add("Components");
        menuExpectedList.add("Tablets");
        menuExpectedList.add("Software");
        menuExpectedList.add("Phones & PDAs");
        menuExpectedList.add("Cameras");
        menuExpectedList.add("MP3 Players");

        for (int i=0; i<menuExpectedList.size(); i++)
            Assert.assertEquals(menuActualList.get(i).getText(), menuExpectedList.get(i),"Menu beklenen gibi degil");

    }

}
