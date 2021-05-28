package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage{

   By addToCartButtonBy = By.id("add-to-basket");
   By discountPriceBy  = By.id("sp-price-discountPrice");
   By highProductPriceBy = By.cssSelector("#sp-price-highPrice");
   By goToCartBy =By.className("robot-header-iconContainer-cart");
   By getPriceBy =By.id("sp-price-discountPrice");
    public ProductDetailPage(WebDriver webDriver) {

        super(webDriver);
    }

    public void addToCart(){

        click(addToCartButtonBy,7);
    }
    public CartPage goToCart(){
        click(goToCartBy,10);
        return new CartPage(webDriver);
    }

    /*public String getPriceInDetailPage(){
        return webDriver.findElement(discountPriceBy).getText();
    }*/
    public String productPrice (){
        String productPrice = webDriver.findElement(discountPriceBy).getText();
        if(productPrice.isEmpty()){
            return getText(highProductPriceBy);
        }
        return getText(discountPriceBy);
    }
}
