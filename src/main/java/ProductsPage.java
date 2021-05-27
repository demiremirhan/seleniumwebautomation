import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage{
    By productNameLocator =By.cssSelector("product-title bold-opt");


    public ProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectProduct(){
        Random random = new Random();
        int rand = random.nextInt(48)+1;
        getAllProducts().get(rand).click();
    }

    public void choosePage(String pageNumber) {
        webDriver.get(webDriver.getCurrentUrl()+"&sf="+pageNumber);
    }

    private List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }
}
