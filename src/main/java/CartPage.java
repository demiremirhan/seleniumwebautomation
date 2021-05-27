import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By priceInCartBy = By.className("extra-discounted");
    private By numberOfProductBy = By.cssSelector("option[value='2']");
    private By deleteProductBy = By.className("gg-icon gg-icon-bin-medium");
    private By emptyCartBy = By.className("new-price");

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public int priceInCart(){
        String price =find(priceInCartBy).getText();
        return Integer.parseInt(price);
    }

    public void setNumberOfProduct(){
        click(numberOfProductBy);
    }

    public int isEmpty(){
        String price = find(emptyCartBy).getText();
        return Integer.parseInt(price);
    }

    public void deleteProduct(){
        click(deleteProductBy);
    }

}
