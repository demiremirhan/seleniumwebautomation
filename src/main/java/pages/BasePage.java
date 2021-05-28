package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    By searchBoxBy = By.className("sc-4995aq-0");
    By loginButtonBy = By.cssSelector("a[data-cy='header-login-button']");
    By loginOrRegisterButtonBy = By.cssSelector("div[data-cy='header-user-menu']");
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
    public void click(By locator, int timeOut){
        WebDriverWait wait = new WebDriverWait(webDriver, timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public boolean isDisplayed(By locator){return find(locator).isDisplayed(); }

    public LoginPage getLoginPage(){
        moveToElement(loginOrRegisterButtonBy);
        click(loginButtonBy,5);
        return new LoginPage(webDriver);
    }
    public ProductsPage search(String text){
        webDriver.findElement(searchBoxBy).sendKeys(text+ Keys.ENTER);
        return new ProductsPage(webDriver);
    }
    public void sendKeys(By locator,String text){
        WebDriverWait wait= new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
    }
    public String getText(By locator){
        WebDriverWait wait = new WebDriverWait(webDriver,10);
       return wait.until(ExpectedConditions.elementToBeClickable(locator)).getText();
    }
    public void moveToElement(By locator){
        WebElement element = webDriver.findElement(locator);
        String strJavaScript="" +
                "var element= arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); " +
                "mouseEventObj.initEvent( 'mouseover', true, true ); element.dispatchEvent(mouseEventObj);";
        ((JavascriptExecutor)webDriver).executeScript(strJavaScript,element);
    }

    public void scrollToPage(String pixel){
        JavascriptExecutor jexc = (JavascriptExecutor) webDriver;
        jexc.executeScript("window.scrollBy(0,"+pixel+")");
    }
}
