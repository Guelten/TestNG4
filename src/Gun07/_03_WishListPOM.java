package Gun07;

import Gun06._02_PlaceOrderElements;
import Utils.BaseDriver;
import Utils.BaseDriverParameter;
import Utils.Tools;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _03_WishListPOM extends BaseDriver {

    @Test
    @Parameters("itemName")
    void addToWishList(String arananKelime)
    {
        Gun06._02_PlaceOrderElements poe = new _02_PlaceOrderElements();

        poe.searchBox.sendKeys(arananKelime);
        poe.searchButton.click();

        Gun07._02_WishListElements wle = new _02_WishListElements();

        int rndNumber = Tools.RandomNumberGenerator(wle.searchResults.size());  // sonuclarin listesinden bir eleman sectim
        String wishItemName = wle.searchResults.get(rndNumber).getText();  // ürünün text ini aldim
        wle.wishBtnList.get(rndNumber).click(); // ayni ürünün wish list ine tiklattim
        wle.btnWishList.click(); // wish list sayfasina gittim

        Tools.listContainsString(wle.wishTableNames, wishItemName);
    }
}
