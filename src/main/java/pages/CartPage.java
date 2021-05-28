package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By priceInCartBy = By.className("total-price");
    private By numberOfProductBy = By.cssSelector("option[value='2']");
    private By deleteProductBy = By.cssSelector("a[title='Sil']");
    private By emptyCartBy = By.cssSelector(".gg-w-22.gg-d-22.gg-t-21.gg-m-18>:nth-child(1)");
    private By totalProductBy=By.cssSelector("li[class='clearfix total-price-sticky-container']>:nth-of-type(1)");

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
        return webDriver.findElement(totalProductBy).getText();
    }

    public String isEmpty(){
      return webDriver.findElement(emptyCartBy).getText();
    }

    public void deleteProduct(){
        click(deleteProductBy,2);
    }

}
