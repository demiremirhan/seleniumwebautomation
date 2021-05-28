package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    private By priceInCartBy = By.className("total-price");
    private By numberOfProductBy = By.cssSelector("option[value='2']");
    private By deleteProductBy = By.cssSelector("a[title='Sil']");
    private By emptyCartBy = By.cssSelector(".gg-w-22 > h2:nth-child(1)");
    private By totalProductBy=By.cssSelector("li.clearfix:nth-child(1) > div:nth-child(1)");
    private By cartButtonPngBy=By.className(".gg-icon.gg-icon-cart");
            By cartEmptyPriceBy= By.id("cart-total-price");

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }
    public String priceInCart(){
        return webDriver.findElement(priceInCartBy).getText();
    }
    public void setNumberOfProduct(){
        click(numberOfProductBy,10);
    }
    public String getNumberProduct(){
        return webDriver.findElement(numberOfProductBy).getText();
    }
    public String isEmpty(){
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        return webDriver.findElement(cartEmptyPriceBy).getAttribute("value");
    }
    public void deleteProduct(){
        click(deleteProductBy,2);
    }
}
