package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage{
    By productNameLocator =By.className("img-cont");
    By locator =By.id("search-keys-panel");


    public ProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectProduct(){
        Random random = new Random();
        int rand = random.nextInt(47)+1;
        getAllProducts().get(rand).click();
    }

    private List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }

    public void choosePage(String pageNumber) {
        waitForLoad();
        webDriver.get(webDriver.getCurrentUrl() + "&sf=" + pageNumber);
    }
    public void waitForLoad(){
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

}
