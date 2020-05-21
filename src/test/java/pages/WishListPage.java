package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WishListPage extends MainPage {

    public boolean isWishListPageHeaderDisplayed() {
        return isElementDisplayed(By.xpath("//h1[contains(text(), 'Мои закладки')]"));
    }

    public WebElement buyButtonForProductInTheWishListPage() {
        return driver.findElement(By.xpath("//a[contains(text(), 'Купить')]"));
    }

    public boolean isProductInTheWithListPageDisplayed(String product){
        return isElementDisplayed(By.xpath(String.format("//*[contains(@class,'tem-product-inner')][a[contains(.,'%s')]]", product)));
    }
}
