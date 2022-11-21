package Gun07;

import Utils.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _02_WishListElements {

    public _02_WishListElements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "//div[@id='content']/div/div//h4")
    List<WebElement> searchResults;

    @FindBy(xpath = "//button[@data-original-title='Add to Wish List']")
    List<WebElement> wishBtnList;

    @FindBy(id = "wishlist-total")
    WebElement btnWishList;

    @FindBy(xpath = "td[class='text-left']>a")
    List<WebElement> wishTableNames;

}

