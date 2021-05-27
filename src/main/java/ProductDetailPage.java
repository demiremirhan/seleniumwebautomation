import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage{

   By addToCartBy = By.id("buy-now");
   By goToCartBy =By.className("header-cart-hidden-link");
   By getPriceBy =By.id("sp-price-discountPrice");
    public ProductDetailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void addToCart(){
        click(addToCartBy);
    }
    public void goToCart(){
        click(goToCartBy);
    }
    public int getPriceInDetailPage(){
        String price =find(getPriceBy).getText();
        return Integer.parseInt(price);
    }
}
