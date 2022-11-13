package Gun01;

/*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe işlemini abone lunuz(YES)
  3- Newsletter  Subscribe islemini abonelikten cikiniz(NO)
  4-
 */

import Utils.BaseDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static Utils.BaseDriver.driver;

public class _06_SubscribeNewsletter {

    By link=By.linkText("Newsletter");
    By yes=By.cssSelector("[type='radio'][value='1']");
    By cnt=By.cssSelector("[value='Continue']");
    By no=By.cssSelector("[type='radio'][value='0']");

    @Test
    void subscribeFunctionYes()
    {
        WebElement newLetterLink=driver.findElement(link);
        newLetterLink.click();

        WebElement subscribeYes=driver.findElement(yes);
        subscribeYes.click();

        WebElement continueButton=driver.findElement(cnt);
        continueButton.click();

        Tools.successMessageValidation();
    }

    @Test
    void subscribeFunctionNo()
    {
        WebElement newLetterLink= driver.findElement(link);
        newLetterLink.click();

        WebElement subscribeNo= driver.findElement(no);
        subscribeNo.click();

        WebElement continueButton= driver.findElement(cnt);
        continueButton.click();

        Tools.successMessageValidation();
    }

    @Test(priority = 2)
    void subscribeFunctionForNo(){
        WebElement newsLetterLink = driver.findElement(link);
        newsLetterLink.click();

        WebElement subscribeNo = driver.findElement(no);
        subscribeNo.click();

        WebElement continueButton = driver.findElement(cnt);
        continueButton.click();

        Tools.successMessageValidation();

    }

    @Test(priority = 3)
    void subscribeFunctionForBoth(){

        WebElement newLetterLink =driver.findElement(link);
        newLetterLink.click();

        WebElement subscribeYes=driver.findElement(yes);
        WebElement subscribeNo=driver.findElement(no);

        if (subscribeYes.isSelected())
            subscribeNo.click();
        else
            subscribeYes.click();

        WebElement continueButton = driver.findElement(cnt);
        continueButton.click();


        Tools.successMessageValidation();
    }
}
