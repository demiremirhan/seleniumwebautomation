package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage{

   By addToCartButtonBy = By.id("add-to-basket");
   By lowProductPriceBy  = By.id("sp-price-lowPrice");
   By highProductPriceBy = By.id("sp-price-highPrice");
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

    public String getPriceInDetailPage(){
        String price =find(getPriceBy).getText();
        return price;
    }
    public String productPrice (){
        String productPrice = webDriver.findElement(lowProductPriceBy).getText();
        if(productPrice.isEmpty()){
            return getText(highProductPriceBy);
        }
        return getText(lowProductPriceBy);
    }
}
