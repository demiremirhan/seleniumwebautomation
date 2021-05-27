import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.List;

public class BasePage {
    By searchBoxBy = By.className("sc-4995aq-0 sc-14oyvky-0 gHqOYK");
    WebDriver webDriver;

    public BasePage (WebDriver webDriver){
        this.webDriver= webDriver;
    }

    public WebElement find(By locator){
        return webDriver.findElement(locator);
    }
    public List<WebElement> findAll(By locator){
        return webDriver.findElements(locator);
    }
    public void click(By locator){
        find(locator).click();
    }
    public boolean isDisplayed(By locator){

        return find(locator).isDisplayed();
    }
    public ProductsPage search(String text){
        webDriver.findElement(searchBoxBy).sendKeys(text+ Keys.ENTER);
        return new ProductsPage(webDriver);
    }
}
